
package path.senior.concurrency.j;

public final class SafeAccount {
    private int cents;

    public SafeAccount(int cents) {
        this.cents = cents;
    }

    public void withdraw(int amount) {
        throw new UnsupportedOperationException("Implement me");
    }

    public int cents() {
        return cents;
    }
}
