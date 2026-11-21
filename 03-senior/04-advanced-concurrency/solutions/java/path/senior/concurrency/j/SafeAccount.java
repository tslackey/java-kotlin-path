
package path.senior.concurrency.j;

public final class SafeAccount {
    private int cents;

    public SafeAccount(int cents) {
        this.cents = cents;
    }

    public synchronized void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount");
        }
        if (amount > cents) {
            throw new IllegalStateException("insufficient");
        }
        cents -= amount;
    }

    public synchronized int cents() {
        return cents;
    }
}
