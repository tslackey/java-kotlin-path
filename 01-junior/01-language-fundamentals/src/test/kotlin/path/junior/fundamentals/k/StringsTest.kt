package path.junior.fundamentals.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringsTest {

    @Test
    fun reverse() {
        assertThat(Strings.reverse("")).isEqualTo("")
        assertThat(Strings.reverse("ab")).isEqualTo("ba")
        assertThat(Strings.reverse("path")).isEqualTo("htap")
    }

    @Test
    fun palindromeIgnoresNoise() {
        assertThat(Strings.isPalindrome("")).isTrue()
        assertThat(Strings.isPalindrome("Aa")).isTrue()
        assertThat(Strings.isPalindrome("Never odd or even")).isTrue()
        assertThat(Strings.isPalindrome("race a car")).isFalse()
    }

    @Test
    fun wordCount() {
        assertThat(Strings.wordCount("")).isZero()
        assertThat(Strings.wordCount("   ")).isZero()
        assertThat(Strings.wordCount("one")).isEqualTo(1)
        assertThat(Strings.wordCount("  one   two two ")).isEqualTo(3)
    }
}
