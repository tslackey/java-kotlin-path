
package path.junior.errors.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountTest {

    @Test
    fun withdrawAndTransfer() {
        val from = Account(100)
        val to = Account(5)
        val result = from.transferTo(to, 40)
        assertThat(result).isEqualTo(TransferResult.Ok(60, 45))
        assertThat(from.cents).isEqualTo(60)
        assertThat(to.cents).isEqualTo(45)
    }

    @Test
    fun invalidAmount() {
        val account = Account(50)
        assertThat(account.withdraw(0)).isEqualTo(TransferResult.InvalidAmount(0))
        assertThat(account.deposit(-1)).isEqualTo(TransferResult.InvalidAmount(-1))
        assertThat(account.cents).isEqualTo(50)
    }

    @Test
    fun overdraftDoesNotChangeBalance() {
        val account = Account(50)
        assertThat(account.withdraw(51)).isEqualTo(TransferResult.InsufficientFunds(51, 50))
        assertThat(account.cents).isEqualTo(50)
    }

    @Test
    fun parserCollectsErrors() {
        val outcome = IntParser.parse(listOf("1", "nope", "3"))
        assertThat(outcome.values).containsExactly(1, 3)
        assertThat(outcome.errors).hasSize(1).allMatch { it.contains("2") }
    }
}
