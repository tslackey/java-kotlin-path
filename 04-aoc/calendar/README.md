# AoC calendar starters

Each recommended day has a Java object and a Kotlin object with `part1` / `part2`, plus a link to the real puzzle. **Read the puzzle on adventofcode.com.** Do not paste puzzle text into this repo.

```bash
./gradlew :aoc-calendar:test
```

## Your input files

1. Log in at [adventofcode.com](https://adventofcode.com).
2. Open the day (links below).
3. Put **your** input in:

```
04-aoc/calendar/inputs/YYYY/dayNN.txt
```

Example: `04-aoc/calendar/inputs/2015/day01.txt`

Those files are gitignored. Never commit puzzle text or other people's inputs.

Optional: `dayNN-sample.txt` and `dayNN-answers.txt` (two lines: part1 answer, part2 answer) for a self-check. `PuzzleInputs` will load them if present; tests skip when they are missing.

## Recommended days

Junior (after fundamentals / collections):

| Day | Puzzle | Practice |
| --- | --- | --- |
| 2015-01 | https://adventofcode.com/2015/day/1 | scan a string |
| 2022-01 | https://adventofcode.com/2022/day/1 | grouping |
| 2023-01 | https://adventofcode.com/2023/day/1 | parsing mixed tokens |

Mid (after APIs / collections fluency):

| Day | Puzzle | Practice |
| --- | --- | --- |
| 2021-03 | https://adventofcode.com/2021/day/3 | bits / columns |
| 2022-05 | https://adventofcode.com/2022/day/5 | stacks |
| 2015-06 | https://adventofcode.com/2015/day/6 | 2D grids |

Senior (after performance / graphs):

| Day | Puzzle | Practice |
| --- | --- | --- |
| 2019-06 | https://adventofcode.com/2019/day/6 | trees |
| 2021-15 | https://adventofcode.com/2021/day/15 | shortest path |

Implement **Java and Kotlin** for each day you count. Tick them in `progress/PROGRESS.md`.

`src/main/.../DayTemplate` is the copy-paste starter for any other year/day.
