# Java vs Kotlin — fundamentals

| Topic | Java | Kotlin |
| --- | --- | --- |
| Entry function | `public static void main` | `fun main()` |
| Null | every reference may be null | `String` vs `String?` |
| Equality | `==` is identity for objects; `equals` is value | `==` calls `equals`; `===` is identity |
| Switch | `switch` / `switch` expressions | `when` is an expression |
| String templates | concatenation or `formatted` | `"Hello $name"` |
| Namespace | class with static methods | `object` or top-level functions |

If your Kotlin `FizzBuzz` is a class with a constructor you never use, make it an `object` (or top-level functions). If your Java version is a pile of instance methods with no state, make the methods `static`.
