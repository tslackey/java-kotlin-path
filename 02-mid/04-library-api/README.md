# Library API (Spring Boot)

A mixed Java + Kotlin service: Java owns HTTP + JPA entities, Kotlin owns checkout.

```bash
make run-library
# http://localhost:8080/api/books
./gradlew :mid-library-api:test
```

## Goals

- See Spring Boot, JPA, and constructor injection in a small app you can read end-to-end
- Keep a **use case** (checkout) out of the controller
- Prevent an illegal state (two loans for one book) in the service, not with a hope and a comment

## What already works

- `POST /api/books` `{"title","author","isbn"}`
- `GET /api/books`
- `POST /api/members` `{"name"}`
- `GET /api/members`

H2 console: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:library`)

## What you implement

`LoanService.checkout(bookId, memberId)` in Kotlin:

1. Book and member must exist
2. Book must be available
3. Create a `Loan`, set the book unavailable, save both
4. If the book is already out, fail (throw `IllegalStateException`)

`POST /api/loans` `{"bookId":1,"memberId":1}` hits that method.

Java stubs are not the exercise — read them. The Kotlin service is.

## Done when

- Tests green, including the double-checkout case
- You can sketch controller → service → repository without looking
- You hit the API with `curl` or an HTTP client, not only tests
