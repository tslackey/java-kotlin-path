
package path.junior.testing.j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class LeapYearTest {

    @Test
    void typicalLeapAndCommonYears() {
        fail("Write assertions for 2024, 1900, 2000, 2023 using LeapYear.isLeap");
    }
}

class PricingTest {

    @Test
    void discountExamples() {
        fail("Write assertions for Pricing.discount — include 0%, 100%, and a HALF_UP case such as 1 cent at 50%");
    }

    @Test
    void rejectsBadInput() {
        fail("assertThatThrownBy for negative cents and percent outside 0..100");
    }
}
