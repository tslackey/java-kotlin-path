package path.aoc.calendar.j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public final class PuzzleInputs {
    private PuzzleInputs() {}

    public static Path repoRoot() {
        Path cwd = Path.of("").toAbsolutePath();
        Path here = cwd;
        while (here != null) {
            if (Files.exists(here.resolve("04-aoc"))) {
                return here;
            }
            here = here.getParent();
        }
        return cwd;
    }

    public static Path inputFile(int year, int day) {
        return repoRoot().resolve("04-aoc/calendar/inputs/%d/day%02d.txt".formatted(year, day));
    }

    public static String load(int year, int day) throws IOException {
        Path file = inputFile(year, day);
        if (!Files.exists(file)) {
            throw new IOException("Missing %s — download YOUR input from https://adventofcode.com/%d/day/%d and save it there."
                    .formatted(file, year, day));
        }
        return Files.readString(file, StandardCharsets.UTF_8);
    }

    public static Optional<String> sample(int year, int day) throws IOException {
        Path file = repoRoot().resolve("04-aoc/calendar/inputs/%d/day%02d-sample.txt".formatted(year, day));
        if (!Files.exists(file)) {
            return Optional.empty();
        }
        return Optional.of(Files.readString(file, StandardCharsets.UTF_8));
    }
}
