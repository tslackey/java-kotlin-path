
package path.aoc.gym.k

import java.util.PriorityQueue

object CheapestClimb {
    fun minCost(grid: String): Int {
        val rows = grid.trim().lines()
        val h = rows.size
        val w = rows[0].length
        val cost = Array(h) { IntArray(w) { Int.MAX_VALUE } }
        val pq = PriorityQueue(compareBy<IntArray> { it[0] })
        val start = rows[0][0] - '0'
        cost[0][0] = start
        pq.add(intArrayOf(start, 0, 0))
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            val c = cur[0]
            val r = cur[1]
            val col = cur[2]
            if (c != cost[r][col]) continue
            if (r == h - 1 && col == w - 1) return c
            for (step in dirs) {
                val rr = r + step[0]
                val cc = col + step[1]
                if (rr !in 0 until h || cc !in 0 until w) continue
                val next = c + (rows[rr][cc] - '0')
                if (next < cost[rr][cc]) {
                    cost[rr][cc] = next
                    pq.add(intArrayOf(next, rr, cc))
                }
            }
        }
        error("unreachable")
    }
}
