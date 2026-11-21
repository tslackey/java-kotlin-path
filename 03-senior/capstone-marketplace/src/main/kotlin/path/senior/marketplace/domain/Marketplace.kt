
package path.senior.marketplace.domain

data class Listing(
    val id: String,
    val sellerId: String,
    val title: String,
    val priceCents: Long,
    var stock: Int,
)

data class Order(
    val id: String,
    val listingId: String,
    val buyerId: String,
    val qty: Int,
    val totalCents: Long,
)

class Marketplace {
    fun listItem(sellerId: String, title: String, priceCents: Long, stock: Int): Listing {
        TODO("Implement me")
    }

    fun listings(): List<Listing> {
        TODO("Implement me")
    }

    fun placeOrder(buyerId: String, listingId: String, qty: Int): Order {
        TODO("Implement me")
    }
}
