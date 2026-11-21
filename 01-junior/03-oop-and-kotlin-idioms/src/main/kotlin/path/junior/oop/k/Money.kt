
package path.junior.oop.k

data class Money(val currency: String, val cents: Long) {
    operator fun plus(other: Money): Money {
        TODO("Implement me")
    }
}
