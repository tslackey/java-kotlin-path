
package path.junior.errors.k

data class ParseOutcome(val values: List<Int>, val errors: List<String>)

object IntParser {
    fun parse(lines: List<String>): ParseOutcome {
        TODO("Implement me")
    }
}
