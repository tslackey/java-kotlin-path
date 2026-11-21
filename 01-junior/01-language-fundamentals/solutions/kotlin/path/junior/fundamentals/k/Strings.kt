package path.junior.fundamentals.k

object Strings {
    fun reverse(input: String): String = input.reversed()

    fun isPalindrome(input: String): Boolean {
        val cleaned = input.filter { it.isLetterOrDigit() }.lowercase()
        return cleaned == cleaned.reversed()
    }

    fun wordCount(input: String): Int {
        val trimmed = input.trim()
        if (trimmed.isEmpty()) return 0
        return trimmed.split(Regex("\\s+")).size
    }
}
