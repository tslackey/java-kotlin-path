# Java vs Kotlin — small apps

Java `Main` uses a switch on the command. Kotlin can use `when`.

File I/O: Java `Files.readAllLines` / `Files.write`; Kotlin `File.readLines()` / `writeText`. Same bytes.

Keep the store dumb. Parsing argv in `Main` and persisting in `TaskStore` is already two classes — do not invent a framework.
