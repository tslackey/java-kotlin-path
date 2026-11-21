
package path.junior.nullsafety.k

class Directory(users: Map<String, User>) {
    private val users = users.toMap()

    fun find(id: String?): User? {
        TODO("Implement me")
    }

    fun displayName(id: String?): String {
        TODO("Implement me")
    }

    companion object {
        fun parsePositiveInt(raw: String?): Int? {
            TODO("Implement me")
        }
    }
}
