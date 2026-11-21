package path.junior.fundamentals.k

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumbersTest {

    @Test
    fun factorial() {
        assertThat(Numbers.factorial(0)).isEqualTo(1L)
        assertThat(Numbers.factorial(1)).isEqualTo(1L)
        assertThat(Numbers.factorial(5)).isEqualTo(120L)
        assertThat(Numbers.factorial(20)).isEqualTo(2_432_902_008_176_640_000L)
        assertThatThrownBy { Numbers.factorial(-1) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Numbers.factorial(21) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun primes() {
        assertThat(Numbers.isPrime(1)).isFalse()
        assertThat(Numbers.isPrime(2)).isTrue()
        assertThat(Numbers.isPrime(3)).isTrue()
        assertThat(Numbers.isPrime(4)).isFalse()
        assertThat(Numbers.isPrime(97)).isTrue()
        assertThat(Numbers.isPrime(100)).isFalse()
    }

    @Test
    fun clamp() {
        assertThat(Numbers.clamp(5, 0, 10)).isEqualTo(5)
        assertThat(Numbers.clamp(-1, 0, 10)).isEqualTo(0)
        assertThat(Numbers.clamp(99, 0, 10)).isEqualTo(10)
        assertThatThrownBy { Numbers.clamp(1, 10, 0) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
