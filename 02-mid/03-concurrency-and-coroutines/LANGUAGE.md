# Java vs Kotlin — concurrency

| | Java 21 | Kotlin |
| --- | --- | --- |
| Unit of work | `Runnable` / `Callable` / virtual thread | `suspend` function |
| Pool | `ExecutorService` | `Dispatchers.Default` / `IO` |
| Compose async | `CompletableFuture.thenCompose` | `async` / `await` in a `coroutineScope` |
| Structured concurrency | emerging (`StructuredTaskScope`) | the default if you do not use `GlobalScope` |
| Shared mutable state | `synchronized`, atomics, concurrent collections | same JVM primitives; actors/channels optional |

Coroutines are *not* threads. A thousand coroutines can sit on a handful of threads. Virtual threads (next level) close some of that gap for Java I/O.

Never `Thread.sleep` in a `suspend` function — `delay`. Never hide `runBlocking` inside library code.
