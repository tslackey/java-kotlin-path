# Mid

Goal: put the languages on a network boundary. After this level you can build a small Spring service, test it, and choose a concurrency style on purpose.

| Order | Module | You should be able to |
| --- | --- | --- |
| 1 | [Gradle and build](01-gradle-and-build/README.md) | Read this repo’s build, add a task, explain a dependency |
| 2 | [APIs and data](02-apis-and-data/README.md) | JSON → DTO → domain, a repository, a fake HTTP client |
| 3 | [Concurrency and coroutines](03-concurrency-and-coroutines/README.md) | Executors, `CompletableFuture`, structured coroutines |
| 4 | [Library API](04-library-api/README.md) | Spring Boot, JPA, a mixed Java/Kotlin codebase |
| 5 | [Testing in depth](05-testing-in-depth/README.md) | Mockito (Java) and MockK (Kotlin) against a port |

```bash
make test-mid
make run-library
```

Library API: http://localhost:8080 — try `GET /api/books` after it boots.

## Ready for senior?

- [ ] `make test-mid` is green on your code
- [ ] `POST /api/loans` refuses to check out a book that is already out
- [ ] You can sketch the layers of the library API (controller / service / repository) on paper
- [ ] You can say when you want a thread pool, a `CompletableFuture` pipeline, or `coroutineScope` + `async`
- [ ] You have one test that mocks a collaborator and one test that boots Spring (or a slice)
- [ ] You can add a Gradle dependency and find it in `./gradlew :mid-library-api:dependencies`

Senior is mostly judgment. If the library API still feels like magic, stay here and read the Spring code until it does not.

Tracker: [progress/PROGRESS.md](../progress/PROGRESS.md). Gate: [progress/rubrics.md](../progress/rubrics.md). Mid AoC set: [04-aoc](../04-aoc/README.md).
