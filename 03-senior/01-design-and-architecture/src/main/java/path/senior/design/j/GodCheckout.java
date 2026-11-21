
package path.senior.design.j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Inherited mess. Do not extend this. Read it, then implement {@link CheckoutService}.
 */
public final class GodCheckout {
    public final Map<String, Integer> stock = new HashMap<>();
    public final List<String> cardLog = new ArrayList<>();
    public final List<Ports.Order> orders = new ArrayList<>();
    public boolean declineNext;

    public Ports.Order place(String sku, int qty, String customerId, long cents) {
        Integer have = stock.get(sku);
        if (have == null) {
            throw new IllegalArgumentException("unknown sku");
        }
        if (qty > have) {
            throw new IllegalStateException("insufficient stock");
        }
        cardLog.add(customerId + ":" + cents);
        if (declineNext) {
            declineNext = false;
            throw new IllegalStateException("payment declined");
        }
        stock.put(sku, have - qty);
        Ports.Order order = new Ports.Order(UUID.randomUUID().toString(), sku, qty, customerId, true);
        orders.add(order);
        return order;
    }
}
