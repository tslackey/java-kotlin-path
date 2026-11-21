
package path.junior.testing.k

object LeapYear {
    fun isLeap(year: Int): Boolean = when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        else -> year % 4 == 0
    }
}
