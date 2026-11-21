package path.junior.fundamentals.j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @Test
    void factorial() {
        assertThat(Numbers.factorial(0)).isEqualTo(1L);
        assertThat(Numbers.factorial(1)).isEqualTo(1L);
        assertThat(Numbers.factorial(5)).isEqualTo(120L);
        assertThat(Numbers.factorial(20)).isEqualTo(2_432_902_008_176_640_000L);
        assertThatThrownBy(() -> Numbers.factorial(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Numbers.factorial(21)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void primes() {
        assertThat(Numbers.isPrime(1)).isFalse();
        assertThat(Numbers.isPrime(2)).isTrue();
        assertThat(Numbers.isPrime(3)).isTrue();
        assertThat(Numbers.isPrime(4)).isFalse();
        assertThat(Numbers.isPrime(97)).isTrue();
        assertThat(Numbers.isPrime(100)).isFalse();
    }

    @Test
    void clamp() {
        assertThat(Numbers.clamp(5, 0, 10)).isEqualTo(5);
        assertThat(Numbers.clamp(-1, 0, 10)).isEqualTo(0);
        assertThat(Numbers.clamp(99, 0, 10)).isEqualTo(10);
        assertThatThrownBy(() -> Numbers.clamp(1, 10, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}
