
package path.senior.perf.k

object TwoSum {
    fun indices(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int, Int>()
        for (i in nums.indices) {
            val other = seen[target - nums[i]]
            if (other != null) return intArrayOf(other, i)
            seen.putIfAbsent(nums[i], i)
        }
        error("no pair")
    }
}

object Uniques {
    fun duplicates(nums: IntArray): Set<Int> {
        val seen = HashSet<Int>()
        val dupes = LinkedHashSet<Int>()
        for (n in nums) {
            if (!seen.add(n)) dupes.add(n)
        }
        return dupes
    }
}

object Joiner {
    fun join(parts: List<String>, sep: String): String = parts.joinToString(sep)
}
