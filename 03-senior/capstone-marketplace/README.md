# Capstone: marketplace

A domain in Kotlin, an HTTP adapter in Java. No Spring — you already did that. The domain must not import the HTTP package.

```bash
./gradlew :senior-marketplace:test
make run-marketplace
# http://localhost:8081/health
```

## Domain rules (tests lock these)

- `listItem(sellerId, title, priceCents, stock)` — stock and price must be > 0
- `placeOrder(buyerId, listingId, qty)`
  - listing must exist and have stock
  - buyer cannot buy their own listing
  - stock decreases; an `Order` is stored
- Money is integer cents

## HTTP (already stubbed; wire it when domain works)

| Method | Path | Body |
| --- | --- | --- |
| GET | `/health` | — |
| GET | `/listings` | — |
| POST | `/listings` | `sellerId`, `title`, `priceCents`, `stock` |
| POST | `/orders` | `buyerId`, `listingId`, `qty` |

You implement `Marketplace.placeOrder` and `Marketplace.listItem` (Kotlin). Java `MarketplaceServer` is a JDK `HttpServer` — read it, then keep it boring.

Solutions at this level are enough to keep CI green plus [SKETCH.md](SKETCH.md) for what a résumé version would add.

## Done when

- Domain tests green on your code
- `make run-marketplace` + a POST listing + POST order works
- You fill [../03-production-habits/CHECKLIST.md](../03-production-habits/CHECKLIST.md)
- You can defend why the domain package has no `com.sun.net.httpserver` import
