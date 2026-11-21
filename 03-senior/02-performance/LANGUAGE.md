# Java vs Kotlin — performance

Both sit on the same JVM. Kotlin's `list.indices.forEach` is not free if you allocate lambdas in a hot loop — use a `for` when it is hot.

`buildString { }` is Kotlin's `StringBuilder`. Java: `StringBuilder` or `String.join`.

`HashMap` / `HashSet` are the same types. Kotlin `mutableMapOf` is a `LinkedHashMap` by default — fine at this size.
