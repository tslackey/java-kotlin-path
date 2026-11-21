
package path.aoc.gym.k

object ReachableCells {
    fun count(grid: String): Int {
        val rows = grid.trimIndent().lines()
        val h = rows.size
        val w = rows[0].length
        var start = 0 to 0
        rows.forEachIndexed { r, row ->
            val c = row.indexOf('S')
            if (c >= 0) start = r to c
        }
        val seen = Array(h) { BooleanArray(w) }
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(start)
        seen[start.first][start.second] = true
        var n = 0
        val dirs = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        while (q.isNotEmpty()) {
            val (r, c) = q.removeFirst()
            n++
            for ((dr, dc) in dirs) {
                val rr = r + dr
                val cc = c + dc
                if (rr !in 0 until h || cc !in 0 until w || seen[rr][cc]) continue
                if (rows[rr][cc] == '#') continue
                seen[rr][cc] = true
                q.add(rr to cc)
            }
        }
        return n
    }
}
