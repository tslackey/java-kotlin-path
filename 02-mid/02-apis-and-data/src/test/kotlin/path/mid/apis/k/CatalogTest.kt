
package path.mid.apis.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CatalogTest {

    @Test
    fun jsonAndRepository() {
        CatalogTest::class.java.getResourceAsStream("/books.json").use { input ->
            val books = JsonCatalog.load(input!!)
            assertThat(books).hasSize(3)
            assertThat(books[0].title).isEqualTo("Effective Java")
            val repo = InMemoryBookRepository()
            books.forEach(repo::save)
            assertThat(repo.findByIsbn("978-2")).isEqualTo(books[1])
        }
    }

    @Test
    fun serviceUsesClient() {
        val client = FakeBookClient(
            listOf(
                BookJson("1", "A", "Ada", 10),
                BookJson("2", "B", "Alan", 10),
                BookJson("3", "C", "Ada", 10),
            ),
        )
        assertThat(CatalogService(client).titlesForAuthor("ada")).containsExactly("A", "C")
    }
}
