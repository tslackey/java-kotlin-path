#!/usr/bin/env python3
"""Print a PASS/FAIL table from JUnit XML. Run after ./gradlew test --continue."""

from __future__ import annotations

import xml.etree.ElementTree as ET
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]

MODULES = [
    ("junior-fundamentals", "Junior · fundamentals"),
    ("junior-collections", "Junior · collections"),
    ("junior-oop", "Junior · OOP / idioms"),
    ("junior-null-safety", "Junior · null safety"),
    ("junior-errors", "Junior · errors"),
    ("junior-testing", "Junior · testing"),
    ("junior-task-tracker", "Junior · task tracker"),
    ("mid-gradle", "Mid · Gradle"),
    ("mid-apis", "Mid · APIs and data"),
    ("mid-concurrency", "Mid · concurrency"),
    ("mid-library-api", "Mid · library API"),
    ("mid-testing", "Mid · testing in depth"),
    ("senior-design", "Senior · design"),
    ("senior-performance", "Senior · performance"),
    ("senior-production", "Senior · production"),
    ("senior-concurrency", "Senior · concurrency"),
    ("senior-marketplace", "Senior · marketplace"),
    ("aoc-gym", "AoC · gym"),
    ("aoc-calendar", "AoC · calendar scaffolding"),
]


PROJECT_DIRS = {
    "junior-fundamentals": "01-junior/01-language-fundamentals",
    "junior-collections": "01-junior/02-collections",
    "junior-oop": "01-junior/03-oop-and-kotlin-idioms",
    "junior-null-safety": "01-junior/04-null-safety",
    "junior-errors": "01-junior/05-error-handling",
    "junior-testing": "01-junior/06-testing-basics",
    "junior-task-tracker": "01-junior/project-task-tracker",
    "mid-gradle": "02-mid/01-gradle-and-build",
    "mid-apis": "02-mid/02-apis-and-data",
    "mid-concurrency": "02-mid/03-concurrency-and-coroutines",
    "mid-library-api": "02-mid/04-library-api",
    "mid-testing": "02-mid/05-testing-in-depth",
    "senior-design": "03-senior/01-design-and-architecture",
    "senior-performance": "03-senior/02-performance",
    "senior-production": "03-senior/03-production-habits",
    "senior-concurrency": "03-senior/04-advanced-concurrency",
    "senior-marketplace": "03-senior/capstone-marketplace",
    "aoc-gym": "04-aoc/gym",
    "aoc-calendar": "04-aoc/calendar",
}


def tally(project: str) -> tuple[str, int, int, int]:
    folder = ROOT / PROJECT_DIRS[project] / "build" / "test-results" / "test"
    if not folder.exists():
        return "NO-RUN", 0, 0, 0
    tests = failures = errors = 0
    for xml in folder.glob("TEST-*.xml"):
        root = ET.parse(xml).getroot()
        tests += int(root.attrib.get("tests", 0))
        failures += int(root.attrib.get("failures", 0))
        errors += int(root.attrib.get("errors", 0))
    if tests == 0:
        return "NO-RUN", 0, 0, 0
    if failures or errors:
        return "FAIL", tests, failures, errors
    return "PASS", tests, 0, 0


def main() -> None:
    lines = [
        "# Last test run",
        "",
        "| Module | Status | Tests | Failures | Errors |",
        "| --- | --- | ---: | ---: | ---: |",
    ]
    print(f"{'Module':<36} {'Status':<8} {'tests':>6} {'fail':>6} {'err':>6}")
    print("-" * 70)
    passed = failed = missing = 0
    for project, label in MODULES:
        status, tests, failures, errors = tally(project)
        print(f"{label:<36} {status:<8} {tests:>6} {failures:>6} {errors:>6}")
        lines.append(f"| {label} | {status} | {tests} | {failures} | {errors} |")
        if status == "PASS":
            passed += 1
        elif status == "FAIL":
            failed += 1
        else:
            missing += 1
    summary = f"PASS {passed} · FAIL {failed} · NO-RUN {missing} · {passed}/{len(MODULES)} modules green"
    print("-" * 70)
    print(summary)
    print()
    print("A module PASSES only if its tests are green on YOUR code.")
    print("Tick boxes in progress/PROGRESS.md. Read progress/rubrics.md before changing level.")
    lines.extend(["", summary, ""])
    out = ROOT / "progress" / "last-run.md"
    out.write_text("\n".join(lines) + "\n")
    print(f"Wrote {out.relative_to(ROOT)}")


if __name__ == "__main__":
    main()
