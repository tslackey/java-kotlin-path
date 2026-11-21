# Progress tracker

This is the steering wheel. Tests tell you if the code passed. This file tells you where you are and what is next.

How to use it:

1. Work a module (Java **and** Kotlin).
2. Run the module tests until green. Or run `make status` and look for `PASS`.
3. Answer the self-review prompts in [self-review.md](self-review.md).
4. Tick the boxes below. A module is not done because you peeked at `solutions/`.
5. Do not start the next **level** until that level's promotion rubric in [rubrics.md](rubrics.md) is honest.

`make status` is the machine check. These checkboxes are the human check. You need both.

---

## Setup

- [ ] JDK 21 installed (`make setup` works)
- [ ] `make first` has been run (red on a fresh clone is expected)

## Junior

- [ ] Language fundamentals — Java
- [ ] Language fundamentals — Kotlin
- [ ] Collections — Java
- [ ] Collections — Kotlin
- [ ] OOP / Kotlin idioms — Java
- [ ] OOP / Kotlin idioms — Kotlin
- [ ] Null safety — Java
- [ ] Null safety — Kotlin
- [ ] Error handling — Java
- [ ] Error handling — Kotlin
- [ ] Testing basics (you wrote the tests)
- [ ] Task tracker CLI — Java (add/list/done + restart)
- [ ] Task tracker CLI — Kotlin
- [ ] Self-review for junior ([self-review.md](self-review.md))
- [ ] **Level gate:** junior rubric in [rubrics.md](rubrics.md)

AoC after junior (optional but recommended):

- [ ] Gym: Altitude log (Java + Kotlin)
- [ ] Gym: Receipt batches (Java + Kotlin)
- [ ] Calendar: [2015-01](https://adventofcode.com/2015/day/1)
- [ ] Calendar: [2022-01](https://adventofcode.com/2022/day/1)
- [ ] Calendar: [2023-01](https://adventofcode.com/2023/day/1)

## Mid

- [ ] Gradle and build
- [ ] APIs and data — Java
- [ ] APIs and data — Kotlin
- [ ] Concurrency and coroutines — Java
- [ ] Concurrency and coroutines — Kotlin
- [ ] Library API: books/members run
- [ ] Library API: checkout + double-loan rejected
- [ ] Testing in depth — Mockito
- [ ] Testing in depth — MockK
- [ ] Self-review for mid
- [ ] **Level gate:** mid rubric

AoC after mid:

- [ ] Gym: Reachable cells
- [ ] Gym: Merge windows
- [ ] Calendar: [2021-03](https://adventofcode.com/2021/day/3)
- [ ] Calendar: [2022-05](https://adventofcode.com/2022/day/5)
- [ ] Calendar: [2015-06](https://adventofcode.com/2015/day/6)

## Senior

- [ ] Design and architecture — Java
- [ ] Design and architecture — Kotlin
- [ ] Performance (including timed tests)
- [ ] Production habits
- [ ] Advanced concurrency
- [ ] Capstone: domain tests
- [ ] Capstone: HTTP smoke (`make run-marketplace`)
- [ ] Ops checklist filled
- [ ] Self-review for senior
- [ ] **Level gate:** senior rubric

AoC after senior:

- [ ] Gym: Cheapest climb
- [ ] Calendar: [2019-06](https://adventofcode.com/2019/day/6)
- [ ] Calendar: [2021-15](https://adventofcode.com/2021/day/15)

## Machine check

```bash
make status              # your code
make status-solutions    # reference implementations (CI)
```

Paste or drop the latest table from `progress/last-run.md` here if you want a paper trail.
