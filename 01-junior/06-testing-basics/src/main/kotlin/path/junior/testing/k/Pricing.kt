
package path.junior.testing.k

import java.math.BigDecimal
import java.math.RoundingMode

object Pricing {
    fun discount(cents: Long, percent: Int): Long {
        require(cents >= 0) { "cents" }
        require(percent in 0..100) { "percent" }
        val factor = BigDecimal.valueOf(100L - percent).divide(BigDecimal.valueOf(100))
        return BigDecimal.valueOf(cents).multiply(factor).setScale(0, RoundingMode.HALF_UP).longValueExact()
    }
}
