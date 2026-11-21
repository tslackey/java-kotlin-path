# Java vs Kotlin — data mapping

Jackson works in both. Kotlin needs `jackson-module-kotlin` for data classes and default parameters.

Java records map cleanly onto JSON objects if names match. Kotlin data classes too — prefer `val`.

A repository interface in Java is a `interface`. In Kotlin too. Do not make it a sealed class.

`BookClient` returning `List<BookJson>` is a bit leaky. A stricter API would return domain books. We left the leak in so you can decide whether to map in the client or the service — pick one and be consistent.
