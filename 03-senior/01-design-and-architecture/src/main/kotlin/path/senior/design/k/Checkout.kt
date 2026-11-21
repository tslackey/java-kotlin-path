
package path.senior.design.k

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
        TODO("Implement me — see GodCheckout and SKETCH.md")
    }
}
