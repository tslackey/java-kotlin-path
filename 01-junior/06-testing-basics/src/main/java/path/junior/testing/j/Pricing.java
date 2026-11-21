
package path.junior.testing.j;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Pricing {
    private Pricing() {}

    public static long discount(long cents, int percent) {
        if (cents < 0) {
            throw new IllegalArgumentException("cents");
        }
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent");
        }
        BigDecimal factor = BigDecimal.valueOf(100 - percent).divide(BigDecimal.valueOf(100));
        return BigDecimal.valueOf(cents).multiply(factor).setScale(0, RoundingMode.HALF_UP).longValueExact();
    }
}
