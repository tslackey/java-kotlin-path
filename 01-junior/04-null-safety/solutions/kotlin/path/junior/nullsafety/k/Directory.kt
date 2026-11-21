
package path.junior.nullsafety.k

class Directory(users: Map<String, User>) {
    private val users = users.toMap()

    fun find(id: String?): User? = id?.let { users[it] }

    fun displayName(id: String?): String {
        val name = find(id)?.name
        return if (name.isNullOrBlank()) "Unknown" else name
    }

    companion object {
        fun parsePositiveInt(raw: String?): Int? {
            val value = raw?.trim()?.toIntOrNull() ?: return null
            return value.takeIf { it > 0 }
        }
    }
}
