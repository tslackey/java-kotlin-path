package path.junior.fundamentals.j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringsTest {

    @Test
    void reverse() {
        assertThat(Strings.reverse("")).isEqualTo("");
        assertThat(Strings.reverse("ab")).isEqualTo("ba");
        assertThat(Strings.reverse("path")).isEqualTo("htap");
    }

    @Test
    void palindromeIgnoresNoise() {
        assertThat(Strings.isPalindrome("")).isTrue();
        assertThat(Strings.isPalindrome("Aa")).isTrue();
        assertThat(Strings.isPalindrome("Never odd or even")).isTrue();
        assertThat(Strings.isPalindrome("race a car")).isFalse();
    }

    @Test
    void wordCount() {
        assertThat(Strings.wordCount("")).isZero();
        assertThat(Strings.wordCount("   ")).isZero();
        assertThat(Strings.wordCount("one")).isEqualTo(1);
        assertThat(Strings.wordCount("  one   two two ")).isEqualTo(3);
    }
}
