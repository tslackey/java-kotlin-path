
package path.mid.gradle.k

object TodoCounter {
    fun count(source: String): Int {
        if (source.isEmpty()) return 0
        return Regex("TODO").findAll(source).count()
    }
}
