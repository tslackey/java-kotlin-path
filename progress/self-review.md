# Self-review prompts

After each module, write short answers (a notes file is fine). If you cannot answer, the module is not done.

## Every module

1. What failed first, and what did that teach you?
2. Where do the Java and Kotlin versions **intentionally** differ?
3. What would you delete if a reviewer asked “why is this here?”

## Junior extras

- Fundamentals: show a case where Java `==` on strings lies to you.
- Null safety: write one method signature you would refuse to ship with a raw nullable return in Java.
- Errors: when would you throw vs return a sealed result?

## Mid extras

- Gradle: what does the wrapper protect you from?
- APIs: why is `BookJson` not the domain `Book`?
- Concurrency: what breaks if you use `GlobalScope`?
- Library API: where does the transaction start?

## Senior extras

- Design: which port would you fake in a unit test, and which would you not?
- Performance: what was the complexity before and after?
- Production: what will wake you up at 3am if it is missing?
- Capstone: draw the boxes. If HTTP sits inside the domain, redo it.

## AoC extras

- What parsing trick did you reuse from a career module?
- Did you write the second language by translating, or by using that language's collections?
