package path.junior.fundamentals.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EqualityTest {

    @Test
    fun internedLiteralsShareAReference() {
        val a = "path"
        val b = "path"
        assertThat(Equality.sameReference(a, b)).isTrue()
        assertThat(Equality.valueEqual(a, b)).isTrue()
    }

    @Test
    fun constructedStringsAreEqualButNotTheSameReference() {
        val a = "path"
        val b = String("path".toCharArray())
        assertThat(Equality.valueEqual(a, b)).isTrue()
        assertThat(Equality.sameReference(a, b)).isFalse()
    }

    @Test
    fun nullSafeValueEquality() {
        assertThat(Equality.valueEqual(null, null)).isTrue()
        assertThat(Equality.valueEqual(null, "x")).isFalse()
    }
}
