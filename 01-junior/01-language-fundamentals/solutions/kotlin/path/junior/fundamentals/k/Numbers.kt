package path.junior.fundamentals.k

object Numbers {
    fun factorial(n: Int): Long {
        require(n in 0..20) { "n must be 0..20" }
        var result = 1L
        for (i in 2..n) {
            result *= i
        }
        return result
    }

    fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n % 2 == 0) return n == 2
        var i = 3
        while (i.toLong() * i <= n) {
            if (n % i == 0) return false
            i += 2
        }
        return true
    }

    fun clamp(value: Int, min: Int, max: Int): Int {
        require(min <= max) { "min > max" }
        return value.coerceIn(min, max)
    }
}
