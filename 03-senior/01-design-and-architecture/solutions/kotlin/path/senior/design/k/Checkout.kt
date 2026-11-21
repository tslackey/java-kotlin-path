
package path.senior.design.k

import java.util.UUID

data class Order(val id: String, val sku: String, val qty: Int, val customerId: String, val paid: Boolean)

interface Inventory {
    fun available(sku: String): Int
    fun reserve(sku: String, qty: Int)
}

fun interface Payments {
    fun charge(customerId: String, cents: Long): Boolean
}

fun interface Orders {
    fun save(order: Order): Order
}

class InMemoryInventory : Inventory {
    private val stock = mutableMapOf<String, Int>()

    fun seed(sku: String, qty: Int) {
        stock[sku] = qty
    }

    override fun available(sku: String): Int =
        stock[sku] ?: throw IllegalArgumentException("unknown sku")

    override fun reserve(sku: String, qty: Int) {
        val have = available(sku)
        if (qty > have) throw IllegalStateException("insufficient stock")
        stock[sku] = have - qty
    }
}

class CheckoutService(
    private val inventory: Inventory,
    private val payments: Payments,
    private val orders: Orders,
) {
    fun place(sku: String, qty: Int, customerId: String, cents: Long): Order {
        require(qty > 0) { "qty" }
        val have = inventory.available(sku)
        if (qty > have) throw IllegalStateException("insufficient stock")
        if (!payments.charge(customerId, cents)) {
            throw IllegalStateException("payment declined")
        }
        inventory.reserve(sku, qty)
        return orders.save(Order(UUID.randomUUID().toString(), sku, qty, customerId, paid = true))
    }
}
