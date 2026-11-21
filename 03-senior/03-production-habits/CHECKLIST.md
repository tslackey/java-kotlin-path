# Ops checklist (use on the capstone)

- [ ] Health endpoint
- [ ] Config from env, documented defaults
- [ ] Logs go to stdout; no passwords
- [ ] `make test` / CI runs on every push
- [ ] README says how to run, port, and how to know it is up
- [ ] Failures return a non-2xx (not an HTML stack trace to clients)
- [ ] One paragraph in the capstone README: what you would add next (auth, Postgres, metrics) and why it is not faked
