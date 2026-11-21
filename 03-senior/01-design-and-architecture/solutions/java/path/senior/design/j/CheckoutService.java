
package path.senior.design.j;

import java.util.UUID;

public final class CheckoutService {
    private final Ports.Inventory inventory;
    private final Ports.Payments payments;
    private final Ports.Orders orders;

    public CheckoutService(Ports.Inventory inventory, Ports.Payments payments, Ports.Orders orders) {
        this.inventory = inventory;
        this.payments = payments;
        this.orders = orders;
    }

    public Ports.Order place(String sku, int qty, String customerId, long cents) {
        if (qty <= 0) {
            throw new IllegalArgumentException("qty");
        }
        int have = inventory.available(sku);
        if (qty > have) {
            throw new IllegalStateException("insufficient stock");
        }
        if (!payments.charge(customerId, cents)) {
            throw new IllegalStateException("payment declined");
        }
        inventory.reserve(sku, qty);
        return orders.save(new Ports.Order(UUID.randomUUID().toString(), sku, qty, customerId, true));
    }
}
