
package path.junior.collections.j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Catalog {
    private Catalog() {}

    public static List<Item> inStock(List<Item> items) {
        return items.stream().filter(Item::inStock).toList();
    }

    public static int totalCentsInStock(List<Item> items) {
        return items.stream().filter(Item::inStock).mapToInt(Item::cents).sum();
    }

    public static Map<String, List<Item>> byDepartment(List<Item> items) {
        return items.stream().collect(Collectors.groupingBy(Item::department));
    }
}
