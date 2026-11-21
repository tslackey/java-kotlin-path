
package path.junior.tracker.k

import java.nio.file.Path
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val file = Path.of("tasks-kotlin.txt")
    val store = TaskStore()
    store.load(file)
    val code = run(store, args)
    store.save(file)
    if (code != 0) {
        exitProcess(code)
    }
}

internal fun run(store: TaskStore, args: Array<String>): Int {
    if (args.isEmpty()) {
        System.err.println("usage: add <title> | list | done <id>")
        return 2
    }
    when (args[0]) {
        "add" -> {
            if (args.size < 2) {
                System.err.println("usage: add <title>")
                return 2
            }
            val task = store.add(args.drop(1).joinToString(" "))
            println(format(task))
        }
        "list" -> store.list().forEach { println(format(it)) }
        "done" -> {
            if (args.size != 2) {
                System.err.println("usage: done <id>")
                return 2
            }
            if (!store.complete(args[1].toInt())) {
                System.err.println("unknown id")
                return 1
            }
        }
        else -> {
            System.err.println("unknown command")
            return 2
        }
    }
    return 0
}

internal fun format(task: Task): String = "${task.id} [${if (task.done) "x" else " "}] ${task.title}"
