
package path.mid.testing.j;

public final class FulfillmentService {
    private final Warehouse warehouse;

    public FulfillmentService(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public boolean placeOrder(String sku, int qty) {
        throw new UnsupportedOperationException("Implement me");
    }
}
