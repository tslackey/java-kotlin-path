
tasks.register<JavaExec>("runJava") {
    group = "application"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("path.junior.tracker.j.Main")
}

tasks.register<JavaExec>("runKotlin") {
    group = "application"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("path.junior.tracker.k.MainKt")
}
