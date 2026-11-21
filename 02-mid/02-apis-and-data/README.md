# APIs and data

JSON on disk, a DTO, a domain type, a repository, a fake HTTP client. No Spring yet.

```bash
./gradlew :mid-apis:test
```

## Goals

- Keep **wire JSON** (`BookJson`) away from **domain** (`Book`)
- Load a catalog from `books.json` on the classpath
- Talk to the network through an interface you can fake in tests

## Exercises

Java *and* Kotlin:

- `BookMapper.toDomain`
- `JsonCatalog.load` from `/books.json`
- `InMemoryBookRepository` — save, find by isbn, find all
- `CatalogService.titlesForAuthor` using `BookClient` (do not call a real URL)

`FakeBookClient` is provided. Point `CatalogService` at it.

## Done when

- Tests green
- You can explain why `BookJson` is not the JPA entity you will write in the next-but-one module
