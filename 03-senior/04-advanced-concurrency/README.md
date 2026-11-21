# Advanced concurrency

Races, rate limits, virtual threads, cancellation.

```bash
./gradlew :senior-concurrency:test
```

## Goals

- Fix a lost-update on a shared balance
- Rate-limit: at most `n` calls per window
- Fan-out work on virtual threads (Java) and cancel a coroutine (Kotlin)

## Exercises

Java: `SafeAccount.withdraw`, `RateLimiter.tryAcquire`, `VirtualFanOut.sum`.
Kotlin: `SafeAccount.withdraw`, `RateLimiter.tryAcquire`, `CancellableWork.runUntilCancelled`.

`RateLimiter` is a simple counter in a window: construct with `(limit, windowMillis, clockMillis)`. Tests inject the clock.

## Done when

- Tests green
- You can explain why `synchronized` on `withdraw` is enough here and when it would not be
