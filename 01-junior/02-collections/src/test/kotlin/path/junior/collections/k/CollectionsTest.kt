
package path.junior.collections.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CollectionsTest {

    private val tea = Item("tea", "drink", 400, true)
    private val coffee = Item("coffee", "drink", 500, false)
    private val cake = Item("cake", "food", 700, true)

    @Test
    fun wordFrequency() {
        assertThat(WordFrequency.count("A a b!")).containsEntry("a", 2L).containsEntry("b", 1L)
        assertThat(WordFrequency.count("")).isEmpty()
    }

    @Test
    fun catalog() {
        val items = listOf(tea, coffee, cake)
        assertThat(Catalog.inStock(items)).containsExactly(tea, cake)
        assertThat(Catalog.totalCentsInStock(items)).isEqualTo(1100)
        assertThat(Catalog.byDepartment(items)).containsOnlyKeys("drink", "food")
        assertThat(Catalog.byDepartment(items)["drink"]).containsExactly(tea, coffee)
    }

    @Test
    fun uniquesKeepFirstSeen() {
        assertThat(Uniques.preserveOrder(listOf("b", "a", "b", "c", "a")))
            .containsExactly("b", "a", "c")
    }
}
