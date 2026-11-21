
tasks.register("todoReport") {
    group = "learning"
    description = "Count TODO markers in this module's main sources"
    doLast {
        val roots = listOf(file("src/main"), file("solutions"))
        val count = roots
            .filter { it.exists() }
            .sumOf { root ->
                root.walkTopDown()
                    .filter { it.isFile && (it.extension == "java" || it.extension == "kt") }
                    .sumOf { file -> file.readText().split("TODO").size - 1 }
            }
        println("TODO markers in mid-gradle sources: $count")
    }
}
