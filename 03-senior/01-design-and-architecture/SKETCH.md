# Solution sketch

Not a unique design. A shape that works:

```
CheckoutService
  - inventory: Inventory      // available / reserve
  - payments: Payments        // charge; false = declined
  - orders: Orders            // save
```

1. `available(sku)` — missing SKU is 0 or unknown; tests treat unknown as exception if you never `seed` it. Seed in tests.
2. If `qty > available` → throw before payment.
3. `charge` then `reserve` then `save`, **or** reserve then charge and release on failure. Tests only require: payment failure leaves stock unchanged and saves nothing.
4. Do not put HTTP or JSON in this module.

The reference code under `solutions/` follows charge-then-reserve. If you reserve-first, add a release method to the port — tests still pass if the failure path is correct.
