# Advent of Code — algorithm gym

AoC is **alongside** the career path, not instead of it. Use it for parsing, maps, grids, and graphs after the matching junior/mid/senior modules.

Puzzles and official inputs are owned by [Advent of Code](https://adventofcode.com). This repo does **not** copy puzzle text or Eric Wastl's inputs.

| Track | What it is |
| --- | --- |
| [gym](gym/README.md) | Original problems in an AoC *shape* (parse input, part 1 + part 2). Tests and solutions included. |
| [calendar](calendar/README.md) | Year/day starters that **link** to the real puzzle, plus input-file scaffolding. You paste *your* input. |

## How it sits on the path

Do the language module first, then the matching AoC set:

| After you finish | Gym | Calendar (read the puzzle on adventofcode.com) |
| --- | --- | --- |
| Junior fundamentals + collections | Altitude log, receipt batches | [2015 day 1](https://adventofcode.com/2015/day/1), [2022 day 1](https://adventofcode.com/2022/day/1), [2023 day 1](https://adventofcode.com/2023/day/1) |
| Junior OOP / maps | — | [2015 day 2](https://adventofcode.com/2015/day/2) if you want more parsing |
| Mid APIs + collections comfort | Reachable cells, merge windows | [2021 day 3](https://adventofcode.com/2021/day/3), [2022 day 5](https://adventofcode.com/2022/day/5), [2015 day 6](https://adventofcode.com/2015/day/6) |
| Mid concurrency | — | Any day you solve **both** in Java and Kotlin, timed |
| Senior performance + design | Cheapest climb | [2021 day 15](https://adventofcode.com/2021/day/15), [2019 day 6](https://adventofcode.com/2019/day/6) |

Both languages, every time. Same input, two implementations.

```bash
./gradlew :aoc-gym:test
./gradlew :aoc-calendar:test
make status
```

Tick days in [../progress/PROGRESS.md](../progress/PROGRESS.md).
