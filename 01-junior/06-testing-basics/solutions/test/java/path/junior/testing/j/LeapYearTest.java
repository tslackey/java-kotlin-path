
package path.junior.testing.j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LeapYearTest {

    @ParameterizedTest
    @CsvSource({
            "2024, true",
            "2023, false",
            "1900, false",
            "2000, true",
            "2012, true",
            "2019, false"
    })
    void gregorian(int year, boolean leap) {
        assertThat(LeapYear.isLeap(year)).isEqualTo(leap);
    }
}

class PricingTest {

    @ParameterizedTest
    @CsvSource({
            "100, 0, 100",
            "100, 100, 0",
            "100, 10, 90",
            "1, 50, 1"
    })
    void discount(long cents, int percent, long expected) {
        assertThat(Pricing.discount(cents, percent)).isEqualTo(expected);
    }

    @Test
    void rejectsBadInput() {
        assertThatThrownBy(() -> Pricing.discount(-1, 10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Pricing.discount(10, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Pricing.discount(10, 101)).isInstanceOf(IllegalArgumentException.class);
    }
}
