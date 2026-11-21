
package path.junior.oop.j;

import java.util.Objects;

public record Money(String currency, long cents) {
    public Money {
        Objects.requireNonNull(currency, "currency");
    }

    public Money plus(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("currency mismatch");
        }
        return new Money(currency, cents + other.cents);
    }
}
