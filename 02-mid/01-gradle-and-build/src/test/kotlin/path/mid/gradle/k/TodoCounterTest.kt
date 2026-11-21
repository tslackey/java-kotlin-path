
package path.mid.gradle.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TodoCounterTest {
    @Test
    fun countsNonOverlapping() {
        assertThat(TodoCounter.count("")).isZero()
        assertThat(TodoCounter.count("TODO TODO")).isEqualTo(2)
        assertThat(TodoCounter.count("todo")).isZero()
        assertThat(TodoCounter.count("TODO")).isEqualTo(1)
    }
}
