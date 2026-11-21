# Language fundamentals

Implement each method in **Java and Kotlin**. The tests are the spec.

```bash
make first                          # FizzBuzz only
./gradlew :junior-fundamentals:test  # this whole module
```

## Goals

- Write a function, a loop, and a conditional in both languages
- Know when `"hi" == "hi"` is true in Java (it is not a rule you should rely on) vs Kotlin
- Use `when` / `switch` instead of an `if` pyramid where it reads better

## Exercises

| Class / object | What to implement |
| --- | --- |
| `FizzBuzz` | `of(n)` and inclusive `sequence(from, to)` |
| `Strings` | reverse, palindrome (ignore case + non-alphanumerics), word count |
| `Numbers` | factorial, isPrime, clamp |
| `Equality` | value equality vs reference equality |

Start with FizzBuzz. Do not skip the Kotlin file.

## Done when

- `./gradlew :junior-fundamentals:test` is green
- You can explain the four `Equality` tests to someone else
- You read [LANGUAGE.md](LANGUAGE.md)
