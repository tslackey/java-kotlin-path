
package path.senior.design.j;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckoutServiceTest {

    @Test
    void successReservesAndPays() {
        InMemoryInventory inventory = new InMemoryInventory();
        inventory.seed("tea", 5);
        List<Ports.Order> saved = new ArrayList<>();
        AtomicBoolean charged = new AtomicBoolean();
        CheckoutService service = new CheckoutService(
                inventory,
                (customerId, cents) -> {
                    charged.set(true);
                    return true;
                },
                order -> {
                    saved.add(order);
                    return order;
                }
        );
        Ports.Order order = service.place("tea", 2, "ada", 400);
        assertThat(order.paid()).isTrue();
        assertThat(inventory.available("tea")).isEqualTo(3);
        assertThat(charged).isTrue();
        assertThat(saved).hasSize(1);
    }

    @Test
    void insufficientStockDoesNotCharge() {
        InMemoryInventory inventory = new InMemoryInventory();
        inventory.seed("tea", 1);
        AtomicBoolean charged = new AtomicBoolean();
        CheckoutService service = new CheckoutService(
                inventory,
                (c, cents) -> {
                    charged.set(true);
                    return true;
                },
                order -> order
        );
        assertThatThrownBy(() -> service.place("tea", 2, "ada", 400))
                .isInstanceOf(IllegalStateException.class);
        assertThat(inventory.available("tea")).isEqualTo(1);
        assertThat(charged).isFalse();
    }

    @Test
    void paymentFailureLeavesStock() {
        InMemoryInventory inventory = new InMemoryInventory();
        inventory.seed("tea", 5);
        List<Ports.Order> saved = new ArrayList<>();
        CheckoutService service = new CheckoutService(
                inventory,
                (c, cents) -> false,
                order -> {
                    saved.add(order);
                    return order;
                }
        );
        assertThatThrownBy(() -> service.place("tea", 1, "ada", 400))
                .isInstanceOf(IllegalStateException.class);
        assertThat(inventory.available("tea")).isEqualTo(5);
        assertThat(saved).isEmpty();
    }

    @Test
    void unknownSku() {
        InMemoryInventory inventory = new InMemoryInventory();
        CheckoutService service = new CheckoutService(inventory, (c, cents) -> true, order -> order);
        assertThatThrownBy(() -> service.place("nope", 1, "ada", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
