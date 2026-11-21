
package path.senior.design.j;

import java.util.HashMap;
import java.util.Map;

public final class InMemoryInventory implements Ports.Inventory {
    private final Map<String, Integer> stock = new HashMap<>();

    public void seed(String sku, int qty) {
        stock.put(sku, qty);
    }

    @Override
    public int available(String sku) {
        if (!stock.containsKey(sku)) {
            throw new IllegalArgumentException("unknown sku");
        }
        return stock.get(sku);
    }

    @Override
    public void reserve(String sku, int qty) {
        int have = available(sku);
        if (qty > have) {
            throw new IllegalStateException("insufficient stock");
        }
        stock.put(sku, have - qty);
    }
}
