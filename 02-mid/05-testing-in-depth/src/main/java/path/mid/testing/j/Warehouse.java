
package path.mid.testing.j;

public interface Warehouse {
    int available(String sku);

    void reserve(String sku, int qty);
}
