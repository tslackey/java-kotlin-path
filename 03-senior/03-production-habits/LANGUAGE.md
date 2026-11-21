# Java vs Kotlin — ops code

SLF4J is the API; Logback is the implementation. Same in both languages.

Kotlin: `System.getenv("APP_PORT")?.toIntOrNull() ?: 8081`.
Java: parse carefully, catch `NumberFormatException`.

Do not log the env map. Mask first.
