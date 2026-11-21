# Java vs Kotlin — null

| | Java | Kotlin |
| --- | --- | --- |
| Missing value in an API | `Optional<T>` (or a sentinel, or NPE) | `T?` |
| Unwrap or default | `orElse("Unknown")` | `?: "Unknown"` |
| Map if present | `map` / `flatMap` | `?.` and `let` |
| Assert not null | `orElseThrow` | `!!` (code smell in app code) |
| Platform types | — | Java types show up as `T!` — treat as nullable |

`Optional` is for return types, not for fields or parameters. Kotlin `T?` is for all three.

Java calling Kotlin: a `String?` becomes `@Nullable String`. Kotlin calling Java: assume it can be null unless the Java code is annotated.
