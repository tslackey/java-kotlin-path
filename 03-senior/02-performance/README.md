# Performance

Correctness first, then complexity. The tests check both.

```bash
./gradlew :senior-performance:test
```

## Goals

- Replace an O(n²) lookup with hashing
- Know why `String +=` in a loop hurts, and what to use instead
- Talk about a change with a before/after, not a vibe

## Exercises

| | Java | Kotlin |
| --- | --- | --- |
| Two-sum indices | `TwoSum.indices` | `TwoSum.indices` |
| Duplicates | `Uniques.duplicates` | `Uniques.duplicates` |
| Join | `Joiner.join` | `Joiner.join` |

`TwoSum.indices(nums, target)` returns the two **distinct** indices that add to `target`, lower index first. There is always exactly one pair in the tests.

The large-input tests fail if you scan with nested loops.

## Done when

- Tests green, including the timed ones
- You can explain the complexity of your two-sum in one sentence
