
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
        throw new UnsupportedOperationException("Implement me");
    }

    public void deposit(long amount) {
        throw new UnsupportedOperationException("Implement me");
    }

    public void transferTo(Account other, long amount) {
        throw new UnsupportedOperationException("Implement me");
    }
}
