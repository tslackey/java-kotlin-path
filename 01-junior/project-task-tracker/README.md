# Project: task tracker

A CLI that stores tasks in a text file. Implement it **twice** — Java and Kotlin.

```bash
./gradlew :junior-task-tracker:test
make run-tracker-java
make run-tracker-kotlin
```

The CLIs write `tasks-java.txt` / `tasks-kotlin.txt` in the working directory.

## Commands

```
add Buy milk
list
done 1
```

`list` prints one task per line: `1 [ ] Buy milk` or `1 [x] Buy milk`.

Unknown commands print a one-line error to stderr and leave the store unchanged.

## What you implement

- `TaskStore.add`, `list`, `complete` (complete unknown ids → false)
- `TaskStore.save` / `load` using the line format `id|done|title` (`done` is `0` or `1`)
- Wire `Main` so the commands above work (stubs already parse args)

Titles may contain spaces but not `|`. Reject empty titles.

## Done when

- Tests green for `.j` and `.k`
- You can add two tasks, complete one, quit, run again, and `list` still shows them — **both CLIs**
