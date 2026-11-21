# Java vs Kotlin — tests

Same JUnit 5. Kotlin tests can be slightly shorter (`::class.java` vs `.class`).

Prefer AssertJ over raw `assertEquals` in both languages — the failure diff is better.

Kotlin: `assertThatThrownBy { ... }` takes a lambda. Java: `() -> ...`.

Do not test Kotlin from a Java test class “to save time”. The point of this repo is both.
