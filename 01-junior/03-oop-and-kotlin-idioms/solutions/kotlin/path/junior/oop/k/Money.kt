
package path.junior.oop.k

data class Money(val currency: String, val cents: Long) {
    operator fun plus(other: Money): Money {
        require(currency == other.currency) { "currency mismatch" }
        return copy(cents = cents + other.cents)
    }
}
