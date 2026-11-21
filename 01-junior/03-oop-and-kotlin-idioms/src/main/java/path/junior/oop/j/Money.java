
package path.junior.oop.j;

public record Money(String currency, long cents) {
    public Money plus(Money other) {
        throw new UnsupportedOperationException("Implement me");
    }
}
