
package path.aoc.gym.k

data class Window(val start: Int, val end: Int)

object MergeWindows {
    fun merge(windows: List<Window>): List<Window> {
        if (windows.isEmpty()) return emptyList()
        val sorted = windows.sortedBy { it.start }
        val out = mutableListOf<Window>()
        var cur = sorted.first()
        for (next in sorted.drop(1)) {
            cur = if (next.start <= cur.end) {
                Window(cur.start, maxOf(cur.end, next.end))
            } else {
                out += cur
                next
            }
        }
        out += cur
        return out
    }
}
