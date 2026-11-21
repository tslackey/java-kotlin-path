
package path.junior.errors.k

data class ParseOutcome(val values: List<Int>, val errors: List<String>)

object IntParser {
    fun parse(lines: List<String>): ParseOutcome {
        val values = mutableListOf<Int>()
        val errors = mutableListOf<String>()
        lines.forEachIndexed { index, line ->
            val parsed = line.trim().toIntOrNull()
            if (parsed == null) {
                errors += "line ${index + 1}: '$line'"
            } else {
                values += parsed
            }
        }
        return ParseOutcome(values, errors)
    }
}
