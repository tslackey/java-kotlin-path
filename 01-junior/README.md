# Junior

Goal: stop guessing at the language. After this level you can write Java 21 and Kotlin that a teammate would accept in a small service, and you know where the two languages disagree.

Work the modules **in order**. Both languages, every time.

| Order | Module | You should be able to |
| --- | --- | --- |
| 1 | [Language fundamentals](01-language-fundamentals/README.md) | Types, control flow, strings, equality |
| 2 | [Collections](02-collections/README.md) | Lists, maps, grouping; streams vs Kotlin ops |
| 3 | [OOP and Kotlin idioms](03-oop-and-kotlin-idioms/README.md) | Classes, records, data/sealed classes, extensions |
| 4 | [Null safety](04-null-safety/README.md) | `Optional` vs `?`, never “just return null” |
| 5 | [Error handling](05-error-handling/README.md) | Exceptions, `Result`, sealed outcomes |
| 6 | [Testing basics](06-testing-basics/README.md) | You write the JUnit 5 tests |
| 7 | [Task tracker](project-task-tracker/README.md) | A tiny CLI that persists to disk |

```bash
make test-junior
```

## Ready for mid?

You are ready when **all of these** are true:

- [ ] `make test-junior` is green on **your** code (no `-Psolutions`)
- [ ] Task tracker: add, list, complete, restart the process, list still shows data — in **both** CLIs
- [ ] You can explain, without notes: Java `==` vs `equals`, Kotlin `==` vs `===`
- [ ] You can explain `Optional<T>` vs `T?` and why Kotlin still has `!!`
- [ ] You wrote parameterized tests in the testing module instead of copy-pasting `@Test` methods
- [ ] You read each module’s `LANGUAGE.md` and changed at least one Kotlin solution that looked like Java

If a box is unchecked, stay here. Mid assumes this.

Also tick [progress/PROGRESS.md](../progress/PROGRESS.md). The official junior → mid gate is [progress/rubrics.md](../progress/rubrics.md). After collections, add the junior set in [04-aoc](../04-aoc/README.md).
