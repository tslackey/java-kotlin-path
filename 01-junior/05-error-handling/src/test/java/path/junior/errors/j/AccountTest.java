
package path.junior.errors.j;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountTest {

    @Test
    void withdrawAndTransfer() {
        Account from = new Account(100);
        Account to = new Account(5);
        from.transferTo(to, 40);
        assertThat(from.cents()).isEqualTo(60);
        assertThat(to.cents()).isEqualTo(45);
    }

    @Test
    void invalidAmount() {
        Account account = new Account(50);
        assertThatThrownBy(() -> account.withdraw(0)).isInstanceOf(InvalidAmountException.class);
        assertThatThrownBy(() -> account.deposit(-1)).isInstanceOf(InvalidAmountException.class);
        assertThat(account.cents()).isEqualTo(50);
    }

    @Test
    void overdraftDoesNotChangeBalance() {
        Account account = new Account(50);
        assertThatThrownBy(() -> account.withdraw(51)).isInstanceOf(InsufficientFundsException.class);
        assertThat(account.cents()).isEqualTo(50);
    }

    @Test
    void parserCollectsErrors() {
        var outcome = IntParser.parse(List.of("1", "nope", "3"));
        assertThat(outcome.values()).containsExactly(1, 3);
        assertThat(outcome.errors()).hasSize(1).allMatch(s -> s.contains("2"));
    }
}
