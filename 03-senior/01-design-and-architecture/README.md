# Design and architecture

A checkout flow is trapped in a god class. Pull it apart along **ports** without changing the tests.

```bash
./gradlew :senior-design:test
```

## Goals

- Separate domain rules from inventory, payments, and persistence
- Depend on interfaces (ports); tests supply fakes
- Keep the public API (`CheckoutService.place`) stable while the insides change

Read `GodCheckout` first. It is the code you would inherit. You implement `CheckoutService` using `Inventory`, `Payments`, and `Orders`.

## Rules the tests lock

- Unknown SKU → `IllegalArgumentException`
- Insufficient stock → `IllegalStateException`, **no** payment, **no** order
- Payment failure → stock is **not** reduced, no order
- Success → stock drops, payment captured, order saved with `paid` true

## Done when

- Tests green on your `CheckoutService` (Java **and** Kotlin)
- `GodCheckout` is something you could explain in a review, then refuse to ship
- You read [LANGUAGE.md](LANGUAGE.md) and [SKETCH.md](SKETCH.md)
