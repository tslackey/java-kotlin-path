
package path.senior.marketplace.domain

import java.util.UUID

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
    private val listings = linkedMapOf<String, Listing>()
    private val orders = mutableListOf<Order>()

    fun listItem(sellerId: String, title: String, priceCents: Long, stock: Int): Listing {
        require(sellerId.isNotBlank()) { "sellerId" }
        require(title.isNotBlank()) { "title" }
        require(priceCents > 0) { "priceCents" }
        require(stock > 0) { "stock" }
        val listing = Listing(UUID.randomUUID().toString(), sellerId, title, priceCents, stock)
        listings[listing.id] = listing
        return listing
    }

    fun listings(): List<Listing> = listings.values.toList()

    fun placeOrder(buyerId: String, listingId: String, qty: Int): Order {
        require(buyerId.isNotBlank()) { "buyerId" }
        require(qty > 0) { "qty" }
        val listing = listings[listingId] ?: throw IllegalArgumentException("unknown listing")
        require(listing.sellerId != buyerId) { "cannot buy your own listing" }
        check(listing.stock >= qty) { "insufficient stock" }
        listing.stock -= qty
        val order = Order(UUID.randomUUID().toString(), listingId, buyerId, qty, listing.priceCents * qty)
        orders += order
        return order
    }
}
