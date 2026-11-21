package path.aoc.calendar.j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PuzzleInputsTest {

    @Test
    void missingInputExplainsWhereToPutIt() {
        assertThatThrownBy(() -> PuzzleInputs.load(1999, 99))
                .hasMessageContaining("adventofcode.com/1999/day/99")
                .hasMessageContaining("day99.txt");
    }

    @Test
    void sampleIsOptional() throws Exception {
        assertThat(PuzzleInputs.sample(1999, 99)).isEmpty();
    }

    @Test
    @EnabledIf("samplePresent")
    void selfCheck2015Day1IfYouAddedFiles() throws Exception {
        String sample = PuzzleInputs.sample(2015, 1).orElseThrow();
        // You opt in by creating day01-sample.txt. This only proves the loader works.
        assertThat(sample).isNotBlank();
        assertThat(Files.exists(PuzzleInputs.inputFile(2015, 1))
                || PuzzleInputs.sample(2015, 1).isPresent()).isTrue();
    }

    static boolean samplePresent() {
        try {
            return PuzzleInputs.sample(2015, 1).isPresent();
        } catch (Exception e) {
            return false;
        }
    }
}
