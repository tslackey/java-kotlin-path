# Java vs Kotlin — Spring

This module is one process, two languages. That is normal at mid/senior jobs.

- JPA entities are Java because the ecosystem samples still are. Kotlin entities work too (`kotlin("plugin.jpa")`, `no-arg`) — try it later, not today.
- Spring needs **open** classes for proxies. `kotlin("plugin.spring")` opens types annotated with Spring annotations.
- Prefer constructor injection (`class LoanService(private val books: BookRepository)`) over field `@Autowired`.

Do not put JPA annotations on a Kotlin `data class` until you know the no-arg constructor story. A plain `class Loan` is enough.
