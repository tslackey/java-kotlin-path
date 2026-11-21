# Rubrics — did you actually pass?

A green test run is necessary and not sufficient. Tick a level only if **every** line below is true without squinting.

## Junior → mid

| Evidence | Pass |
| --- | --- |
| `make test-junior` green on **your** sources (no `-Psolutions`) | |
| Task tracker survives process restart in **both** CLIs | |
| You can explain Java `==` vs `equals` and Kotlin `==` vs `===` out loud | |
| You can explain `Optional<T>` vs `T?` and a valid use of `!!` (spoiler: almost none in app code) | |
| You wrote parameterized tests instead of copy-paste `@Test` methods | |
| You changed at least one Kotlin file that looked like Java-in-Kotlin | |

If any row is a stretch, stay on junior. Mid assumes this.

## Mid → senior

| Evidence | Pass |
| --- | --- |
| `make test-mid` green on your sources | |
| Library API: second checkout of the same book is rejected | |
| You sketched controller / service / repository without looking | |
| You can choose executor vs `CompletableFuture` vs `coroutineScope`+`async` for a given job | |
| You have one mock-based unit test and one test that boots Spring (or a slice) | |
| You added or found a Gradle dependency with `./gradlew :mid-library-api:dependencies` | |

## Senior (this repo)

| Evidence | Pass |
| --- | --- |
| Marketplace domain tests green on your code | |
| Domain package does not import the HTTP adapter | |
| Performance module green **including** the time bound | |
| Production checklist completed for the capstone | |
| You can walk through `placeOrder` and name one thing you would add next (auth, Postgres, outbox) without faking it | |

## AoC days

A calendar day counts only if:

- You read the puzzle on adventofcode.com (not a blog recap first)
- Both Java and Kotlin produce the **same** answers on *your* input
- You did not commit the puzzle text or input

Gym exercises count when `./gradlew :aoc-gym:test` is green on your code for that class.
