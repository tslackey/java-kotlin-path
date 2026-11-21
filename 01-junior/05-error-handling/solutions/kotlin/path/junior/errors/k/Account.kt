
package path.junior.errors.k

sealed class TransferResult {
    data class Ok(val fromBalance: Long, val toBalance: Long) : TransferResult()
    data class InvalidAmount(val amount: Long) : TransferResult()
    data class InsufficientFunds(val amount: Long, val balance: Long) : TransferResult()
}

class Account(openingCents: Long) {
    var cents: Long = openingCents
        private set

    init {
        require(openingCents >= 0) { "opening balance" }
    }

    fun withdraw(amount: Long): TransferResult {
        if (amount <= 0) return TransferResult.InvalidAmount(amount)
        if (amount > cents) return TransferResult.InsufficientFunds(amount, cents)
        cents -= amount
        return TransferResult.Ok(cents, cents)
    }

    fun deposit(amount: Long): TransferResult {
        if (amount <= 0) return TransferResult.InvalidAmount(amount)
        cents += amount
        return TransferResult.Ok(cents, cents)
    }

    fun transferTo(other: Account, amount: Long): TransferResult {
        if (amount <= 0) return TransferResult.InvalidAmount(amount)
        if (amount > cents) return TransferResult.InsufficientFunds(amount, cents)
        cents -= amount
        other.cents += amount
        return TransferResult.Ok(cents, other.cents)
    }
}
