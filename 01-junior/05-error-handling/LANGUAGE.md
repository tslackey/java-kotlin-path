# Java vs Kotlin — failures

| | Java | Kotlin |
| --- | --- | --- |
| Unexpected | unchecked exceptions | same (`IllegalStateException`, etc.) |
| Expected domain failure | often exceptions; sometimes a result type | `sealed class`, `Result`, Arrow `Either` |
| Catch | `try/catch/finally` | `try/catch` as an expression; `runCatching` |
| Checked exceptions | still exist; most APIs ignore them | none; Java checked exceptions become unchecked at the Kotlin call site |

Do not wrap everything in `Result`. Validation at the edge (HTTP, CLI) likes typed errors. A null pointer in *your* code wants to crash the test, not become `Result.failure`.
