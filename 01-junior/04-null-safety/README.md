# Null safety

The billion-dollar mistake, twice: once with `Optional`, once with `?`.

```bash
./gradlew :junior-null-safety:test
```

## Goals

- Return “missing” without a raw `null` in Java public APIs
- Use `?.`, `?:`, and `let` in Kotlin instead of `if (x != null)` everywhere
- Parse untrusted strings into numbers without throwing for bad input

## Exercises

`Directory` holds users by id.

- `find(id)` — missing id → empty / null
- `displayName(id)` — `"Unknown"` if missing or if the user has a null/blank name
- `parsePositiveInt(raw)` — empty optional / null if not a positive integer

## Done when

- Tests green
- You did **not** use `!!` in the Kotlin solution
- [LANGUAGE.md](LANGUAGE.md)
