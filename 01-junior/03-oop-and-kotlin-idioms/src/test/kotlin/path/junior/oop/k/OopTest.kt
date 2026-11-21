
package path.junior.oop.k

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test

class OopTest {

    @Test
    fun circleAndRectangle() {
        assertThat(Circle(2.0).area()).isCloseTo(Math.PI * 4, within(1e-9))
        assertThat(Circle(2.0).perimeter()).isCloseTo(4 * Math.PI, within(1e-9))
        assertThat(Rectangle(3.0, 4.0).area()).isEqualTo(12.0)
        assertThat(Rectangle(3.0, 4.0).perimeter()).isEqualTo(14.0)
        assertThat(listOf(Rectangle(2.0, 2.0), Rectangle(1.0, 1.0)).totalArea()).isEqualTo(5.0)
    }

    @Test
    fun moneyAddsSameCurrency() {
        assertThat(Money("USD", 199) + Money("USD", 1)).isEqualTo(Money("USD", 200))
        assertThatThrownBy { Money("USD", 1) + Money("EUR", 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
