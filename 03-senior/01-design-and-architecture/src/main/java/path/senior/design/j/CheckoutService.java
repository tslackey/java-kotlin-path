
package path.senior.design.j;

public final class CheckoutService {
    private final Ports.Inventory inventory;
    private final Ports.Payments payments;
    private final Ports.Orders orders;

    public CheckoutService(Ports.Inventory inventory, Ports.Payments payments, Ports.Orders orders) {
        this.inventory = inventory;
        this.payments = payments;
        this.orders = orders;
    }

    public Ports.Order place(String sku, int qty, String customerId, long cents) {
        throw new UnsupportedOperationException("Implement me — see GodCheckout and SKETCH.md");
    }
}
