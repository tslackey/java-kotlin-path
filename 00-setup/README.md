# Setup

## JDK 21

```bash
java -version
```

You want 21 or newer. Temurin, Oracle, Azul, and the OpenJDK from your package manager are all fine. This repo does not need a system-wide Gradle or Kotlin compiler. `./gradlew` downloads Gradle; the Kotlin plugin compiles `.kt` files.

If `java` is missing:

- macOS: `brew install --cask temurin@21` or use [sdkman](https://sdkman.io/)
- Ubuntu: `sudo apt install openjdk-21-jdk`
- Windows: install Temurin 21 and make sure `java` is on `PATH`

Then from the repo root:

```bash
make setup
make first
```

## IDE

IntelliJ IDEA (Community is enough) is the path of least resistance for mixed Java/Kotlin. Open the repo root. It should pick up Gradle automatically.

VS Code works with the Extension Pack for Java plus the Kotlin extension. Import as a Gradle project.

Do not copy sources into a new project. The Gradle multi-project *is* the project.

## Running one module

```bash
./gradlew :junior-fundamentals:test
./gradlew :junior-fundamentals:test --tests "path.junior.fundamentals.j.FizzBuzzTest"
```

`make first` is that second command plus the Kotlin FizzBuzz test.

## When tests fail

On a fresh clone, almost everything fails. Read the assertion, then implement the stub. A failure that says `UnsupportedOperationException: Implement me` or `NotImplementedError` means you have not started that method.

If Gradle itself cannot start, you are usually on JDK < 21.

## Solutions flag

```bash
./gradlew :junior-fundamentals:test -Psolutions
# or
make test-solutions
```

`-Psolutions` points `main` (and, for the testing module, `test`) at the `solutions/` trees. CI uses this so the reference code stays honest. Your daily work should *not* pass `-Psolutions`.
