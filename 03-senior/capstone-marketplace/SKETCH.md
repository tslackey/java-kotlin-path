# Capstone sketch (not a full product)

Next, in this order, if you keep going:

1. **Auth** — do not trust `buyerId` from the body; take it from a session.
2. **Postgres** — `ListingRepository` is already a port. Add an adapter. Keep tests on the in-memory one.
3. **Idempotent payments** — `Idempotency-Key` header, store the first `Order` for that key.
4. **Outbox** — persist `OrderPlaced` next to the order in the same transaction, publish later.
5. **Metrics** — counters for orders and rejected own-buys.

Do not fake these in v1 of *this* repo. Name them in the README instead.
