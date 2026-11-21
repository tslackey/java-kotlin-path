# Java vs Kotlin — types

| Idea | Java | Kotlin |
| --- | --- | --- |
| Value object | `record` | `data class` (copy, componentN, equals) |
| Closed hierarchy | sealed class (Java 17+) or enum | `sealed class` / `sealed interface` + `when` |
| Singleton | enum / static holder | `object` |
| Extra methods on a type you do not own | utility class | extension function |
| Named args / defaults | overloads / Builder | default parameters |
| Inheritance | classes open unless `final` | classes final unless `open` |

A Kotlin data class is not “Lombok on a class”. It is for data. If it has a 40-line `init` and three collaborators, it is a service — use a class.
