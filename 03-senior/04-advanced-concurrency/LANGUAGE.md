# Java vs Kotlin — hard concurrency

Virtual threads (Java 21): cheap blocking. Use them for I/O fan-out, not as a substitute for thinking about shared mutability.

Kotlin cancellation is cooperative: a `suspend` function only stops at a suspension point (`delay`, `ensureActive`, `yield`). A tight CPU loop ignores cancel unless you check.

Rate limiting belongs in one place. Do not sprinkle `Thread.sleep` in callers.
