
package path.senior.design.k

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CheckoutServiceTest {

    @Test
    fun successReservesAndPays() {
        val inventory = FakeInventory().apply { seed("tea", 5) }
        val saved = mutableListOf<Order>()
        var charged = false
        val service = CheckoutService(
            inventory,
            Payments { _, _ -> charged = true; true },
            Orders { order -> saved += order; order },
        )
        val order = service.place("tea", 2, "ada", 400)
        assertThat(order.paid).isTrue()
        assertThat(inventory.available("tea")).isEqualTo(3)
        assertThat(charged).isTrue()
        assertThat(saved).hasSize(1)
    }

    @Test
    fun insufficientStockDoesNotCharge() {
        val inventory = FakeInventory().apply { seed("tea", 1) }
        var charged = false
        val service = CheckoutService(
            inventory,
            Payments { _, _ -> charged = true; true },
            Orders { it },
        )
        assertThatThrownBy { service.place("tea", 2, "ada", 400) }
            .isInstanceOf(IllegalStateException::class.java)
        assertThat(inventory.available("tea")).isEqualTo(1)
        assertThat(charged).isFalse()
    }

    @Test
    fun paymentFailureLeavesStock() {
        val inventory = FakeInventory().apply { seed("tea", 5) }
        val saved = mutableListOf<Order>()
        val service = CheckoutService(
            inventory,
            Payments { _, _ -> false },
            Orders { saved += it; it },
        )
        assertThatThrownBy { service.place("tea", 1, "ada", 400) }
            .isInstanceOf(IllegalStateException::class.java)
        assertThat(inventory.available("tea")).isEqualTo(5)
        assertThat(saved).isEmpty()
    }

    @Test
    fun unknownSku() {
        val service = CheckoutService(FakeInventory(), Payments { _, _ -> true }, Orders { it })
        assertThatThrownBy { service.place("nope", 1, "ada", 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    private class FakeInventory : Inventory {
        private val stock = mutableMapOf<String, Int>()
        fun seed(sku: String, qty: Int) {
            stock[sku] = qty
        }
        override fun available(sku: String): Int =
            stock[sku] ?: throw IllegalArgumentException("unknown sku")
        override fun reserve(sku: String, qty: Int) {
            stock[sku] = available(sku) - qty
        }
    }
}
