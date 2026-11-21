# Senior

Goal: make calls you can defend. After this level you can refactor toward seams, measure a hot path, ship an app that operators can run, and finish a capstone that looks like work — not a kata.

| Order | Module | You should be able to |
| --- | --- | --- |
| 1 | [Design and architecture](01-design-and-architecture/README.md) | Split a god service along ports |
| 2 | [Performance](02-performance/README.md) | Fix an O(n²) path and talk about allocations |
| 3 | [Production habits](03-production-habits/README.md) | Config, logs, health, review checklist |
| 4 | [Advanced concurrency](04-advanced-concurrency/README.md) | Races, rate limits, virtual threads, cancellation |
| 5 | [Marketplace capstone](capstone-marketplace/README.md) | Domain rules + HTTP adapter |

```bash
make test-senior
make run-marketplace
```

Capstone API: http://localhost:8081

Solutions at this level are **sketches** plus enough code to keep CI honest. There is no single “correct” marketplace. The tests lock the domain rules; the rest is your design.

## You are done with this repo when

- [ ] Domain tests for the marketplace pass on your code
- [ ] You can explain why the domain package does not import the HTTP adapter
- [ ] The performance module is green *including* the time bound
- [ ] You have filled in the production checklist for the capstone (logging, health, config)
- [ ] You would put the capstone on a résumé and survive a walkthrough of `placeOrder`
- [ ] You can name one thing you would do next (auth, Postgres, outbox) and why you did not fake it in v1

That is mid-to-senior territory, not “I watched a course.” Keep building.

Tracker: [progress/PROGRESS.md](../progress/PROGRESS.md). Gate: [progress/rubrics.md](../progress/rubrics.md). Senior AoC set: [04-aoc](../04-aoc/README.md).
