# Gradle and the build

This repository *is* the lab. You already ran `./gradlew`. Now look at how.

```bash
./gradlew :mid-gradle:test
./gradlew :mid-gradle:todoReport
./gradlew :mid-library-api:dependencies --configuration runtimeClasspath
```

## Goals

- Read `settings.gradle.kts` and the root `build.gradle.kts`
- Know what a subproject, a configuration (`implementation` vs `testImplementation`), and the wrapper are
- Add or change a task without copy-pasting XML from 2014

## Exercises

1. Open `settings.gradle.kts`. Find `junior-fundamentals`. That is how `./gradlew :junior-fundamentals:test` works.
2. Implement `TodoCounter.count` in Java **and** Kotlin (count the substring `TODO`, case sensitive).
3. Run `:mid-gradle:todoReport`. It should print a number. Read `build.gradle.kts` in this folder — that task is yours to tweak (change the label, write a file, etc.).

## Done when

- Tests green
- You can explain, in one sentence each: wrapper, toolchain, `implementation` vs `testImplementation`, `-Psolutions`
