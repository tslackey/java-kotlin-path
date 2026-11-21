
package path.mid.testing.j;

public final class FulfillmentService {
    private final Warehouse warehouse;

    public FulfillmentService(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public boolean placeOrder(String sku, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("qty");
        }
        if (warehouse.available(sku) < qty) {
            return false;
        }
        warehouse.reserve(sku, qty);
        return true;
    }
}
