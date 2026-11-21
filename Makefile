.DEFAULT_GOAL := help

GRADLE := ./gradlew
SOLUTIONS := -Psolutions

.PHONY: help setup first test test-solutions test-junior test-mid test-senior test-aoc \
	status status-solutions evaluate \
	run-tracker-java run-tracker-kotlin run-library run-marketplace clean

help:
	@echo "Java + Kotlin Path — commands you will actually use"
	@echo
	@echo "  make setup              Check JDK 21 and download Gradle dependencies"
	@echo "  make first              Run the first FizzBuzz tests (expected to fail until you implement them)"
	@echo "  make status             Run all tests, then print PASS/FAIL per module"
	@echo "  make evaluate           Same as status, then remind you to tick progress/PROGRESS.md"
	@echo
	@echo "  make test               Run all student tests"
	@echo "  make test-junior        Junior-level tests"
	@echo "  make test-mid           Mid-level tests"
	@echo "  make test-senior        Senior-level tests"
	@echo "  make test-aoc           AoC gym + calendar scaffolding"
	@echo "  make test-solutions     Reference solutions (CI / when stuck)"
	@echo "  make status-solutions   PASS/FAIL table for the reference solutions"
	@echo
	@echo "  make run-tracker-java   Junior task-tracker CLI (Java)"
	@echo "  make run-tracker-kotlin Junior task-tracker CLI (Kotlin)"
	@echo "  make run-library        Spring library API on :8080"
	@echo "  make run-marketplace    Capstone HTTP API on :8081"
	@echo
	@echo "  make clean              Remove build outputs"
	@echo
	@echo "Tracker:  progress/PROGRESS.md"
	@echo "Rubric:   progress/rubrics.md"
	@echo "AoC:      04-aoc/README.md"
	@echo "Hint:     tests fail on a fresh clone. That is the point."

setup: gradle/wrapper/gradle-wrapper.jar
	@echo "Java (need 21+):"
	@java -version
	@echo
	$(GRADLE) --version
	$(GRADLE) help --quiet

gradle/wrapper/gradle-wrapper.jar:
	@mkdir -p gradle/wrapper
	@if [ ! -f gradle/wrapper/gradle-wrapper.jar ]; then \
		echo "Downloading Gradle wrapper jar..."; \
		curl -fsSL -o gradle/wrapper/gradle-wrapper.jar \
		  https://raw.githubusercontent.com/gradle/gradle/v8.12.1/gradle/wrapper/gradle-wrapper.jar; \
	fi

first:
	$(GRADLE) :junior-fundamentals:test --tests "path.junior.fundamentals.j.FizzBuzzTest" --tests "path.junior.fundamentals.k.FizzBuzzTest"

test:
	$(GRADLE) test

test-solutions:
	$(GRADLE) test $(SOLUTIONS)

test-junior:
	$(GRADLE) :junior-fundamentals:test :junior-collections:test :junior-oop:test \
		:junior-null-safety:test :junior-errors:test :junior-testing:test :junior-task-tracker:test

test-mid:
	$(GRADLE) :mid-gradle:test :mid-apis:test :mid-concurrency:test :mid-library-api:test :mid-testing:test

test-senior:
	$(GRADLE) :senior-design:test :senior-performance:test :senior-production:test \
		:senior-concurrency:test :senior-marketplace:test

test-aoc:
	$(GRADLE) :aoc-gym:test :aoc-calendar:test

status:
	-$(GRADLE) test --continue
	python3 scripts/status.py

status-solutions:
	-$(GRADLE) test --continue $(SOLUTIONS)
	python3 scripts/status.py

evaluate: status
	@echo
	@echo "Machine check is in progress/last-run.md"
	@echo "Human check: tick progress/PROGRESS.md against progress/rubrics.md"
	@echo "Next module = the first FAIL or empty checkbox, not the one that looks fun."

run-tracker-java:
	$(GRADLE) :junior-task-tracker:runJava

run-tracker-kotlin:
	$(GRADLE) :junior-task-tracker:runKotlin

run-library:
	$(GRADLE) :mid-library-api:bootRun

run-marketplace:
	$(GRADLE) :senior-marketplace:run

clean:
	$(GRADLE) clean
