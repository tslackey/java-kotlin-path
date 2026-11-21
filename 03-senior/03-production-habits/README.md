# Production habits

Code that operators can run. Tests here are small; the checklist is the real work.

```bash
./gradlew :senior-production:test
```

## Goals

- Load config from the environment with safe defaults
- Never log secrets
- Expose liveness in one line of JSON
- Know what you would put in CI besides “it compiles”

## Exercises

- `AppConfig.load` — `APP_PORT` (default 8081), `APP_ENV` (default `dev`)
- `SecretMasker.mask` — replace values for keys containing `token`, `password`, or `secret` (case insensitive)
- `Health.body` — `{"status":"ok","env":"<env>"}`

Then fill the [ops checklist](CHECKLIST.md) for the capstone when you get there.

## Done when

- Tests green
- You can name three things you want in CI besides unit tests
- [LANGUAGE.md](LANGUAGE.md)
