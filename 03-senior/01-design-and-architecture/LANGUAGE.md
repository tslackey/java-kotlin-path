# Java vs Kotlin — design

Ports are interfaces in both languages. Kotlin can use `fun interface` when there is one method.

Prefer a Kotlin `class CheckoutService(...)` with constructor params over a Java builder here — there are three collaborators, not thirty.

Sealed results (`sealed class PlaceResult`) are a good Kotlin alternative to exceptions. The tests use exceptions so Java and Kotlin stay comparable. In the capstone you may switch.
