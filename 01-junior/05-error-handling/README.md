# Error handling

Exceptions for bugs and broken invariants. Typed results for expected failure.

```bash
./gradlew :junior-errors:test
```

## Goals

- Reject invalid amounts and overdrafts with **different** exception types (Java)
- Model the same operations as a Kotlin `sealed` result (no thrown exceptions on the happy/overdraft path)
- Parse a list of ints, collecting per-line errors instead of failing the whole batch

## Done when

- Tests green
- You can argue when you would throw vs return a result in a Spring controller
- [LANGUAGE.md](LANGUAGE.md)
