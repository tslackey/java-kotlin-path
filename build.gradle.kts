import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    java
    kotlin("jvm") apply false
}

allprojects {
    group = "dev.lackey.path"
    version = "1.0.0"
    repositories {
        mavenCentral()
    }
}

subprojects {
    if (name == "mid-library-api") {
        return@subprojects
    }

    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    the<JavaPluginExtension>().toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    the<KotlinJvmProjectExtension>().jvmToolchain(21)

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            allWarningsAsErrors.set(false)
        }
    }

    dependencies {
        val impl = configurations.getByName("implementation")
        val testImpl = configurations.getByName("testImplementation")
        val testRuntime = configurations.getByName("testRuntimeOnly")

        impl("org.jetbrains.kotlin:kotlin-stdlib")
        testImpl("org.junit.jupiter:junit-jupiter:5.11.4")
        testImpl("org.assertj:assertj-core:3.27.3")
        testRuntime("org.junit.platform:junit-platform-launcher")
    }

    if (name == "mid-concurrency" || name == "senior-concurrency" || name == "senior-marketplace") {
        dependencies {
            add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
            add("testImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
        }
    }

    if (name == "mid-apis") {
        dependencies {
            add("implementation", "com.fasterxml.jackson.core:jackson-databind:2.18.2")
            add("implementation", "com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
        }
    }

    if (name == "mid-testing") {
        dependencies {
            add("testImplementation", "org.mockito:mockito-core:5.15.2")
            add("testImplementation", "org.mockito:mockito-junit-jupiter:5.15.2")
            add("testImplementation", "io.mockk:mockk:1.13.16")
        }
    }

    if (name == "senior-production") {
        dependencies {
            add("implementation", "org.slf4j:slf4j-api:2.0.16")
            add("implementation", "ch.qos.logback:logback-classic:1.5.16")
        }
    }

    configureExerciseSources()

    tasks.named<Test>("test") {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = false
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}

fun Project.configureExerciseSources() {
    val useSolutions = findProperty("solutions") != null
    val kotlinExt = the<KotlinJvmProjectExtension>()

    if (useSolutions) {
        val solutionsJava = file("solutions/java")
        val solutionsKotlin = file("solutions/kotlin")
        val solutionsTestJava = file("solutions/test/java")
        val solutionsTestKotlin = file("solutions/test/kotlin")

        val javaDirs = if (solutionsJava.exists()) listOf(solutionsJava) else listOf(file("src/main/java"))
        val kotlinDirs = buildList {
            add(if (solutionsKotlin.exists()) solutionsKotlin else file("src/main/kotlin"))
            addAll(javaDirs)
        }
        sourceSets.named("main") { java.setSrcDirs(javaDirs) }
        kotlinExt.sourceSets.getByName("main").kotlin.setSrcDirs(kotlinDirs)

        if (solutionsTestJava.exists() || solutionsTestKotlin.exists()) {
            val testJavaDirs =
                if (solutionsTestJava.exists()) listOf(solutionsTestJava) else listOf(file("src/test/java"))
            val testKotlinDirs = buildList {
                add(if (solutionsTestKotlin.exists()) solutionsTestKotlin else file("src/test/kotlin"))
                addAll(testJavaDirs)
            }
            sourceSets.named("test") { java.setSrcDirs(testJavaDirs) }
            kotlinExt.sourceSets.getByName("test").kotlin.setSrcDirs(testKotlinDirs)
        }
    }
}
