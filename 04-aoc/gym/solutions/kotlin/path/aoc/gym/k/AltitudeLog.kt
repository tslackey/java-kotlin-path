
package path.aoc.gym.k

object AltitudeLog {
    fun net(steps: String): Int {
        var alt = 0
        for (ch in steps) {
            alt += if (ch == 'U') 1 else -1
        }
        return alt
    }

    fun firstBelowSea(steps: String): Int {
        var alt = 0
        steps.forEachIndexed { i, ch ->
            alt += if (ch == 'U') 1 else -1
            if (alt < 0) return i + 1
        }
        return -1
    }
}
