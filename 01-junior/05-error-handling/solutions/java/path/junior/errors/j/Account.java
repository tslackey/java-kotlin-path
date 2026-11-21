
package path.junior.errors.j;

public final class Account {
    private long cents;

    public Account(long cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("opening balance");
        }
        this.cents = cents;
    }

    public long cents() {
        return cents;
    }

    public void withdraw(long amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("amount must be positive");
        }
        if (amount > cents) {
            throw new InsufficientFundsException("need " + amount + " have " + cents);
        }
        cents -= amount;
    }

    public void deposit(long amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("amount must be positive");
        }
        cents += amount;
    }

    public void transferTo(Account other, long amount) {
        withdraw(amount);
        other.deposit(amount);
    }
}
