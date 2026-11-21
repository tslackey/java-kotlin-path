package path.junior.fundamentals.j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzTest {

    @Test
    void ordinaryNumbers() {
        assertThat(FizzBuzz.of(1)).isEqualTo("1");
        assertThat(FizzBuzz.of(2)).isEqualTo("2");
        assertThat(FizzBuzz.of(4)).isEqualTo("4");
    }

    @Test
    void fizzBuzzAndParts() {
        assertThat(FizzBuzz.of(3)).isEqualTo("Fizz");
        assertThat(FizzBuzz.of(9)).isEqualTo("Fizz");
        assertThat(FizzBuzz.of(5)).isEqualTo("Buzz");
        assertThat(FizzBuzz.of(10)).isEqualTo("Buzz");
        assertThat(FizzBuzz.of(15)).isEqualTo("FizzBuzz");
        assertThat(FizzBuzz.of(30)).isEqualTo("FizzBuzz");
    }

    @Test
    void sequenceInclusive() {
        assertThat(FizzBuzz.sequence(1, 5)).containsExactly("1", "2", "Fizz", "4", "Buzz");
    }

    @Test
    void sequenceRejectsInvertedRange() {
        assertThatThrownBy(() -> FizzBuzz.sequence(5, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
