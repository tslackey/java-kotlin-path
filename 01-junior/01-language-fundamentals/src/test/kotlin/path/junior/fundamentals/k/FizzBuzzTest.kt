package path.junior.fundamentals.k

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class FizzBuzzTest {

    @Test
    fun ordinaryNumbers() {
        assertThat(FizzBuzz.of(1)).isEqualTo("1")
        assertThat(FizzBuzz.of(2)).isEqualTo("2")
        assertThat(FizzBuzz.of(4)).isEqualTo("4")
    }

    @Test
    fun fizzBuzzAndParts() {
        assertThat(FizzBuzz.of(3)).isEqualTo("Fizz")
        assertThat(FizzBuzz.of(9)).isEqualTo("Fizz")
        assertThat(FizzBuzz.of(5)).isEqualTo("Buzz")
        assertThat(FizzBuzz.of(10)).isEqualTo("Buzz")
        assertThat(FizzBuzz.of(15)).isEqualTo("FizzBuzz")
        assertThat(FizzBuzz.of(30)).isEqualTo("FizzBuzz")
    }

    @Test
    fun sequenceInclusive() {
        assertThat(FizzBuzz.sequence(1, 5)).containsExactly("1", "2", "Fizz", "4", "Buzz")
    }

    @Test
    fun sequenceRejectsInvertedRange() {
        assertThatThrownBy { FizzBuzz.sequence(5, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
