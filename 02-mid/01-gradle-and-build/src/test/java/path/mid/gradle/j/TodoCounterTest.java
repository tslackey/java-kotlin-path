
package path.mid.gradle.j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TodoCounterTest {
    @Test
    void countsNonOverlapping() {
        assertThat(TodoCounter.count("")).isZero();
        assertThat(TodoCounter.count("TODO TODO")).isEqualTo(2);
        assertThat(TodoCounter.count("todo")).isZero();
        assertThat(TodoCounter.count("TODO")).isEqualTo(1);
    }
}
