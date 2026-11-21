
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
        TODO("Implement me")
    }

    fun deposit(amount: Long): TransferResult {
        TODO("Implement me")
    }

    fun transferTo(other: Account, amount: Long): TransferResult {
        TODO("Implement me")
    }
}
