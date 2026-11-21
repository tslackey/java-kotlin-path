# Java vs Kotlin — collections

| Job | Java | Kotlin |
| --- | --- | --- |
| Map + filter | `stream().filter().map().toList()` | `.filter { }.map { }` |
| Group | `Collectors.groupingBy` | `groupBy` |
| Count | `Collectors.counting()` / `Collectors.groupingBy(..., counting())` | `groupingBy { }.eachCount()` |
| Mutable vs read-only | `List` is mutable by default (`ArrayList`) | `List` is read-only; `MutableList` to change |
| Sequence vs stream | `Stream` is one-shot | `Sequence` is lazy and reusable in spirit (re-collect) |

Java `List.of` is immutable. Kotlin `listOf` is read-only (may still be a Java mutable list underneath — do not cast it).
