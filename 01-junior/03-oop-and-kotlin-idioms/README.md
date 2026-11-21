# OOP and Kotlin idioms

Java: inheritance, records, interfaces.
Kotlin: the same ideas with data classes, sealed classes, objects, and extensions.

```bash
./gradlew :junior-oop:test
```

## Goals

- Model a closed set of shapes without a `boolean isCircle` flag
- Put behavior on an interface, not a god class
- Use a Java record *and* a Kotlin data class for values
- Add Kotlin behavior without inheriting — extension functions

## Exercises

1. `Shape` hierarchy — `area()` and `perimeter()` for circle and rectangle
2. `Money` — same currency to add; reject mixed currencies
3. Kotlin-only: `List<Shape>.totalArea()` as an extension (Java: a static helper is fine)

## Done when

- Tests green
- Your Kotlin shapes are a `sealed class` (or sealed interface), not an open class with two children you will keep extending forever
- [LANGUAGE.md](LANGUAGE.md) makes sense
