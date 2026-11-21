
package path.junior.collections.k

object WordFrequency {
    fun count(text: String): Map<String, Long> =
        text.lowercase()
            .split(Regex("[^a-z]+"))
            .filter { it.isNotEmpty() }
            .groupingBy { it }
            .eachCount()
            .mapValues { it.value.toLong() }
}
