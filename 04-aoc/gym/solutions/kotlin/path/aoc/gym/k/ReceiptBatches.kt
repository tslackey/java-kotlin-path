
package path.aoc.gym.k

object ReceiptBatches {
    fun maxBatch(input: String): Int = sums(input).maxOrNull() ?: 0

    fun topThreeSum(input: String): Int = sums(input).sortedDescending().take(3).sum()

    private fun sums(input: String): List<Int> {
        val out = mutableListOf<Int>()
        var current = 0
        var inBatch = false
        for (line in input.splitToSequence(Regex("\\R"))) {
            if (line.isBlank()) {
                if (inBatch) {
                    out += current
                    current = 0
                    inBatch = false
                }
            } else {
                current += line.trim().toInt()
                inBatch = true
            }
        }
        if (inBatch) out += current
        return out
    }
}
