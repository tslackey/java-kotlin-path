# Testing basics

The production code is done. **You write the tests.**

```bash
./gradlew :junior-testing:test
```

On a fresh clone this module fails because the tests call `fail(...)`. Replace those bodies.

## Goals

- JUnit 5: `@Test`, `@ParameterizedTest`, `@CsvSource`
- AssertJ: `assertThat` / `assertThatThrownBy`
- Test behavior, not methods (a leap year is a rule, not “coverage of `isLeap`”)

## What to test

| Type | Rules |
| --- | --- |
| `LeapYear` | Gregorian: divisible by 400 → leap; by 100 → not; by 4 → leap |
| `Pricing` | `discount(cents, percent)` — percent 0..100; round **half up** to nearest cent; reject negatives |

Write tests in **Java and Kotlin** (`LeapYearTest` in each package). Parameterized tests beat five copy-pasted methods.

Reference tests live under `solutions/test/` — look after you have some red/green cycles.

## Done when

- `./gradlew :junior-testing:test` is green
- You have at least one `@ParameterizedTest` per language
- You tested a rejection path (`percent = 101`, negative cents)
