
package path.junior.collections.j;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionsTest {

    private static final Item TEA = new Item("tea", "drink", 400, true);
    private static final Item COFFEE = new Item("coffee", "drink", 500, false);
    private static final Item CAKE = new Item("cake", "food", 700, true);

    @Test
    void wordFrequency() {
        assertThat(WordFrequency.count("A a b!")).containsEntry("a", 2L).containsEntry("b", 1L);
        assertThat(WordFrequency.count("")).isEmpty();
    }

    @Test
    void catalog() {
        var items = List.of(TEA, COFFEE, CAKE);
        assertThat(Catalog.inStock(items)).containsExactly(TEA, CAKE);
        assertThat(Catalog.totalCentsInStock(items)).isEqualTo(1100);
        assertThat(Catalog.byDepartment(items)).containsOnlyKeys("drink", "food");
        assertThat(Catalog.byDepartment(items).get("drink")).containsExactly(TEA, COFFEE);
    }

    @Test
    void uniquesKeepFirstSeen() {
        assertThat(Uniques.preserveOrder(List.of("b", "a", "b", "c", "a")))
                .containsExactly("b", "a", "c");
    }
}
