# Concurrency and coroutines

Threads, futures, then coroutines. Same problem, three tools.

```bash
./gradlew :mid-concurrency:test
```

## Goals

- Run CPU-or-wait work on an `ExecutorService` and shut it down
- Compose `CompletableFuture` without `.get()` in a loop
- Use `coroutineScope` + `async` so cancellation is structured
- Make a counter safe for many threads (`AtomicInteger` or equivalent)

## Exercises

| | Java | Kotlin |
| --- | --- | --- |
| Parallel map | `ParallelMapper.map` | `CoroutineMapper.map` |
| Pipeline | `Futures.plusOneThenString` | — |
| Safety | `ThreadSafeCounter` | `ThreadSafeCounter` |

`ParallelMapper` / `CoroutineMapper` apply a function to each element. Tests use a slow identity to show you actually waited for all work.

## Done when

- Tests green (the counter test is 10_000 increments from many tasks — if you use `++` on an `Int`, it will fail)
- You can say, without notes, why `GlobalScope.launch` is a smell
- [LANGUAGE.md](LANGUAGE.md)
