
package path.junior.tracker.k

data class Task(val id: Int, val title: String, val done: Boolean = false) {
    fun complete(): Task = copy(done = true)
}
