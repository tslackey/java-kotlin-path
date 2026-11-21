# Java + Kotlin Path

**Junior → mid → senior. Two languages. One repo. Real code.**

You do not pick Java first or Kotlin first. You implement the same problems in both, then read the short notes on where the languages actually diverge. That is how you stop translating syntax and start thinking in each language.

```
clone → make first → fail (expected) → implement Java + Kotlin → green → next module
```

## First 15 minutes

You need **JDK 21+**. That is the only install. Gradle comes with the wrapper.

```bash
git clone https://github.com/tslackey/java-kotlin-path.git
cd java-kotlin-path
make setup
make first
```

`make first` runs the FizzBuzz tests. They fail on a fresh clone because `FizzBuzz` is a stub. Open both files and implement them:

- `01-junior/01-language-fundamentals/src/main/java/path/junior/fundamentals/j/FizzBuzz.java`
- `01-junior/01-language-fundamentals/src/main/kotlin/path/junior/fundamentals/k/FizzBuzz.kt`

Run `make first` until both are green. Then continue through that module's README.

Track yourself in [progress/PROGRESS.md](progress/PROGRESS.md). `make status` prints PASS/FAIL per module. A level is done only when the [rubric](progress/rubrics.md) is honest, not when you got bored.

`make` with no arguments prints every command.

## How the path works

| Level | Who it is for | What you ship |
| --- | --- | --- |
| [Junior](01-junior/README.md) | You can write a loop and a class, but production Java/Kotlin still feels foggy | Language, collections, OOP vs Kotlin idioms, null safety, errors, tests, a CLI app |
| [Mid](02-mid/README.md) | You can complete junior katas and want code that talks to the world | Gradle, HTTP/JSON/data mapping, threads + coroutines, a Spring Boot API, deeper tests |
| [Senior](03-senior/README.md) | You can ship a service and want judgment, not just features | Design, performance, production habits, hard concurrency, a marketplace capstone |
| [AoC](04-aoc/README.md) | Algorithm practice next to the career modules | Original gym katas + calendar starters that **link** to adventofcode.com (no puzzle text copied) |

Every exercise module has:

1. **Goals** — what “done” means
2. **Java and Kotlin stubs** — `src/main/...` (tests fail until you implement)
3. **Tests** — the spec; do not edit them to make them pass
4. **Solutions** — `solutions/` when you are stuck or want a second opinion
5. **Language notes** — where Java and Kotlin should *not* look the same

Projects (task tracker, library API, marketplace) are small apps, not puzzles. Read the README, run them, then fill in the TODOs.

### Peeking at solutions

```bash
make test-solutions          # the reference implementations, used by CI
```

Use `solutions/` after you have tried. Copying them first trains your eyes, not your hands.

## The map

```
00-setup/                         JDK, IDE, how to run one module
01-junior/
  01-language-fundamentals        types, control flow, strings, equality
  02-collections                  List/Set/Map, streams vs Kotlin ops
  03-oop-and-kotlin-idioms        classes, records, data/sealed, extensions
  04-null-safety                  Optional vs ?, platform types
  05-error-handling               exceptions, Result, sealed outcomes
  06-testing-basics               you write the tests (JUnit 5)
  project-task-tracker            CLI app in Java and in Kotlin
02-mid/
  01-gradle-and-build             the build that is running this repo
  02-apis-and-data                JSON, DTOs, repositories, fake HTTP
  03-concurrency-and-coroutines   executors, CompletableFuture, coroutines
  04-library-api                  Spring Boot, mixed Java + Kotlin service
  05-testing-in-depth             Mockito and MockK against a port
03-senior/
  01-design-and-architecture      ports, messy service → seams
  02-performance                  complexity, allocations, a timed hot path
  03-production-habits            config, logging, health, review checklist
  04-advanced-concurrency         races, rate limits, virtual threads, cancel
  capstone-marketplace            domain + HTTP adapter, senior project
04-aoc/
  gym/                            original AoC-shaped problems with tests
  calendar/                       year/day starters + input scaffolding
progress/                         tracker, rubrics, self-review
```

## How to know you are ready

Do not advance on vibes.

1. **Machine:** `make status` (or `make test-junior` / `test-mid` / `test-senior`) — the module is `PASS`.
2. **Human:** tick [progress/PROGRESS.md](progress/PROGRESS.md) and answer [self-review.md](progress/self-review.md).
3. **Gate:** every row in [progress/rubrics.md](progress/rubrics.md) for that level.

Short version:

**Junior → mid** when all junior tests are green (your code, not the solutions), the task tracker can add / list / complete and survive a restart, and you can explain — out loud — `Optional` vs `T?`, `==` in Java vs Kotlin, and why a data class is not “just a Lombok `@Value`”.

**Mid → senior** when the library API runs, checkout refuses a second loan on the same book, you have a mock-based unit test *and* a Spring slice or boot test, and you can describe when you would pick an executor, a `CompletableFuture`, or a coroutine.

**Senior** when the marketplace domain tests pass, you can defend the package layout, the performance fix has a before/after you measured, and you would be willing to put the capstone on a résumé with a paragraph about the tradeoffs.

## Daily loop

1. One module. Both languages. Same tests.
2. After green, read `LANGUAGE.md` in that folder. Change the Kotlin if you wrote Java-in-Kotlin, and the Java if you wrote Kotlin-in-Java.
3. For projects, run the app, not only the tests.
4. Keep a notes file. Senior engineers remember the bugs they made.

## Commands

| Command | What it does |
| --- | --- |
| `make` / `make help` | This list, from the Makefile |
| `make setup` | JDK check + Gradle warmup |
| `make first` | FizzBuzz tests only |
| `make status` | Run tests and print a PASS/FAIL table |
| `make evaluate` | Status + reminder to tick the tracker |
| `make test-junior` | All junior student tests |
| `make test-mid` | All mid student tests |
| `make test-senior` | All senior student tests |
| `make test` | Everything (will fail until you implement) |
| `make test-aoc` | AoC gym + calendar loader tests |
| `make test-solutions` | Reference solutions |
| `make run-tracker-java` | Junior CLI (Java) |
| `make run-tracker-kotlin` | Junior CLI (Kotlin) |
| `make run-library` | Spring API at http://localhost:8080 |
| `make run-marketplace` | Capstone API at http://localhost:8081 |
| `./gradlew :junior-collections:test` | One module |

## Conventions

- Packages ending in `.j` are Java. Packages ending in `.k` are Kotlin. Same problem, two types.
- Stubs throw `UnsupportedOperationException` or `TODO()`. That is intentional.
- Tests are the contract. If a test looks wrong, read the README before changing it.
- Java 21 and Kotlin 2.1. Mixed modules are a feature: real codebases look like this.

## What this is not

Not a MOOC, not a Spring tutorial farm, not “1000 LeetCode problems in Kotlin”. Algorithms show up in the career modules when they teach the language or performance, and in [04-aoc](04-aoc/README.md) as optional Advent of Code practice (links only — we do not copy puzzle text). Android is out of scope for v1.

## License

MIT. See [LICENSE](LICENSE).
