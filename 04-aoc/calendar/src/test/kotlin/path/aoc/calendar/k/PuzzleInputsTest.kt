package path.aoc.calendar.k

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PuzzleInputsTest {

    @Test
    fun missingInputExplainsWhereToPutIt() {
        assertThatThrownBy { PuzzleInputs.load(1999, 99) }
            .hasMessageContaining("adventofcode.com/1999/day/99")
            .hasMessageContaining("day99.txt")
    }

    @Test
    fun sampleIsOptional() {
        assertThat(PuzzleInputs.sample(1999, 99)).isNull()
    }
}
