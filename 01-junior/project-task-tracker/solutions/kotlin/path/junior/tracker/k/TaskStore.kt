
package path.junior.tracker.k

import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.readLines
import kotlin.io.path.writeLines

class TaskStore {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    fun add(title: String): Task {
        require(title.isNotBlank()) { "title" }
        require(!title.contains("|")) { "title cannot contain |" }
        val task = Task(nextId++, title.trim())
        tasks += task
        return task
    }

    fun list(): List<Task> = tasks.toList()

    fun complete(id: Int): Boolean {
        val index = tasks.indexOfFirst { it.id == id }
        if (index < 0) return false
        tasks[index] = tasks[index].complete()
        return true
    }

    fun save(file: Path) {
        file.writeLines(tasks.map { "${it.id}|${if (it.done) 1 else 0}|${it.title}" })
    }

    fun load(file: Path) {
        tasks.clear()
        nextId = 1
        if (!file.exists()) return
        for (line in file.readLines()) {
            if (line.isBlank()) continue
            val parts = line.split("|", limit = 3)
            val task = Task(parts[0].toInt(), parts[2], parts[1] == "1")
            tasks += task
            nextId = maxOf(nextId, task.id + 1)
        }
    }
}
