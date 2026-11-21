package path.senior.marketplace.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MarketplaceTest {

    @Test
    fun listAndBuy() {
        val market = Marketplace()
        val listing = market.listItem("seller", "Tea", 400, 3)
        val order = market.placeOrder("buyer", listing.id, 2)
        assertThat(order.totalCents).isEqualTo(800)
        assertThat(market.listings().single().stock).isEqualTo(1)
    }

    @Test
    fun cannotBuyOwnListing() {
        val market = Marketplace()
        val listing = market.listItem("ada", "Tea", 400, 3)
        assertThatThrownBy { market.placeOrder("ada", listing.id, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(market.listings().single().stock).isEqualTo(3)
    }

    @Test
    fun insufficientStock() {
        val market = Marketplace()
        val listing = market.listItem("seller", "Tea", 400, 1)
        assertThatThrownBy { market.placeOrder("buyer", listing.id, 2) }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun rejectsBadListing() {
        val market = Marketplace()
        assertThatThrownBy { market.listItem("s", "", 1, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { market.listItem("s", "Tea", 0, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
