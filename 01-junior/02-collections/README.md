# Collections

Same transformations, two APIs: Java Streams and Kotlin collection operations.

```bash
./gradlew :junior-collections:test
```

## Goals

- Use `List`, `Set`, and `Map` without reaching for arrays first
- Group, filter, and count
- Prefer library operations over hand-rolled loops *once you can write the loop*

## Exercises

| Type | Behavior |
| --- | --- |
| `WordFrequency` | lowercase tokens → `Map<String, Long>` counts |
| `Catalog` | filter in-stock, total value, group by department |
| `Uniques` | preserve first-seen order when dropping duplicates |

## Done when

- Tests green in both packages
- You read [LANGUAGE.md](LANGUAGE.md) and can say which Kotlin op replaces `Collectors.groupingBy`
