# Java vs Kotlin — builds

The Gradle Kotlin DSL is Kotlin, not “Gradle Java with braces”. `tasks.register<JavaExec>("runJava")` is a typed API.

You can write `build.gradle` in Groovy. This repo uses `.kts` because you are learning Kotlin anyway.

The Kotlin compiler is a Gradle plugin. You do not need `kotlinc` on your PATH. Java compilation uses the JDK toolchain (21 here), not necessarily `JAVA_HOME` if the toolchain can download — in this environment the local JDK 21 is enough.
