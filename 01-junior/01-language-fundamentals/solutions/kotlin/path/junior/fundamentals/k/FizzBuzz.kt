package path.junior.fundamentals.k

object FizzBuzz {
    fun of(n: Int): String = when {
        n % 15 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> n.toString()
    }

    fun sequence(from: Int, to: Int): List<String> {
        require(to >= from) { "to < from" }
        return (from..to).map { of(it) }
    }
}
