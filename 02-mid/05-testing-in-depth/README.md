# Testing in depth

Unit tests against a **port**, not against the whole world. Java uses Mockito. Kotlin uses MockK.

```bash
./gradlew :mid-testing:test
```

The production `Warehouse` is an interface. `FulfillmentService` is the thing you own. Tests should not need a database.

## Goals

- Mock a collaborator; verify an interaction
- Test a failure path (out of stock) without throwing from the mock unless that is the contract
- See the same design in Mockito and MockK

## Exercises

Implement `FulfillmentService.placeOrder(sku, qty)`:

- If `warehouse.available(sku) < qty` → `false`, and **do not** call `reserve`
- Else `warehouse.reserve(sku, qty)` and return `true`

Then complete the tests in `src/test` — they already fail with `fail` / unimplemented service.

Look at `solutions/test` after you have a mock-based test of your own.

The Spring library API (previous module) is where you boot the container. This module is the opposite: **no Spring**.
