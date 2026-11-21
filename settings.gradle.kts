pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "2.1.10"
        kotlin("plugin.spring") version "2.1.10"
        kotlin("plugin.jpa") version "2.1.10"
        id("org.springframework.boot") version "3.4.2"
        id("io.spring.dependency-management") version "1.1.7"
    }
}

rootProject.name = "java-kotlin-path"

fun module(id: String, dir: String) {
    include(id)
    project(":$id").projectDir = file(dir)
}

module("junior-fundamentals", "01-junior/01-language-fundamentals")
module("junior-collections", "01-junior/02-collections")
module("junior-oop", "01-junior/03-oop-and-kotlin-idioms")
module("junior-null-safety", "01-junior/04-null-safety")
module("junior-errors", "01-junior/05-error-handling")
module("junior-testing", "01-junior/06-testing-basics")
module("junior-task-tracker", "01-junior/project-task-tracker")

module("mid-gradle", "02-mid/01-gradle-and-build")
module("mid-apis", "02-mid/02-apis-and-data")
module("mid-concurrency", "02-mid/03-concurrency-and-coroutines")
module("mid-library-api", "02-mid/04-library-api")
module("mid-testing", "02-mid/05-testing-in-depth")

module("senior-design", "03-senior/01-design-and-architecture")
module("senior-performance", "03-senior/02-performance")
module("senior-production", "03-senior/03-production-habits")
module("senior-concurrency", "03-senior/04-advanced-concurrency")
module("senior-marketplace", "03-senior/capstone-marketplace")

module("aoc-gym", "04-aoc/gym")
module("aoc-calendar", "04-aoc/calendar")
