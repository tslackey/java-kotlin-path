# Mockito vs MockK

| | Mockito (Java) | MockK (Kotlin) |
| --- | --- | --- |
| Mock | `@Mock` / `mock(Warehouse.class)` | `mockk()` |
| Stub | `when(w.available("a")).thenReturn(3)` | `every { w.available("a") } returns 3` |
| Verify | `verify(w).reserve("a", 2)` | `verify { w.reserve("a", 2) }` |
| Relaxed | default answers are null/0 | `relaxed = true` or stub everything |

Final Kotlin classes are mockable with MockK (inline / subclass tricks). Mockito needs `mockito-inline` or mockito 5 subclassing — prefer mocking **interfaces**.

That is why `Warehouse` is an interface in both languages.
