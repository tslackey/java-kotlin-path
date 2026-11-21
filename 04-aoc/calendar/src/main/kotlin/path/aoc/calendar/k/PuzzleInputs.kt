package path.aoc.calendar.k

import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.readText

object PuzzleInputs {
    fun repoRoot(): Path {
        var here = Path.of("").toAbsolutePath()
        while (here != null) {
            if (here.resolve("04-aoc").exists()) return here
            here = here.parent
        }
        return Path.of("").toAbsolutePath()
    }

    fun inputFile(year: Int, day: Int): Path =
        repoRoot().resolve("04-aoc/calendar/inputs/$year/day%02d.txt".format(day))

    fun load(year: Int, day: Int): String {
        val file = inputFile(year, day)
        check(file.exists()) {
            "Missing $file — download YOUR input from https://adventofcode.com/$year/day/$day and save it there."
        }
        return file.readText()
    }

    fun sample(year: Int, day: Int): String? {
        val file = repoRoot().resolve("04-aoc/calendar/inputs/$year/day%02d-sample.txt".format(day))
        return if (file.exists()) file.readText() else null
    }
}
