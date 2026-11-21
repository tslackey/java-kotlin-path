
package path.mid.testing.k

interface Warehouse {
    fun available(sku: String): Int
    fun reserve(sku: String, qty: Int)
}

class FulfillmentService(private val warehouse: Warehouse) {
    fun placeOrder(sku: String, qty: Int): Boolean {
        TODO("Implement me")
    }
}
