
package path.mid.testing.k

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FulfillmentServiceTest {

    private val warehouse = mockk<Warehouse>()
    private val service = FulfillmentService(warehouse)

    @Test
    fun reservesWhenInStock() {
        every { warehouse.available("sku") } returns 5
        every { warehouse.reserve("sku", 2) } returns Unit
        assertThat(service.placeOrder("sku", 2)).isTrue()
        verify { warehouse.reserve("sku", 2) }
    }

    @Test
    fun doesNotReserveWhenShort() {
        every { warehouse.available("sku") } returns 1
        assertThat(service.placeOrder("sku", 2)).isFalse()
        verify(exactly = 0) { warehouse.reserve(any(), any()) }
    }
}
