
package path.senior.design.j;

public final class Ports {
    private Ports() {}

    public interface Inventory {
        int available(String sku);

        void reserve(String sku, int qty);
    }

    public interface Payments {
        boolean charge(String customerId, long cents);
    }

    public interface Orders {
        Order save(Order order);
    }

    public record Order(String id, String sku, int qty, String customerId, boolean paid) {}
}
