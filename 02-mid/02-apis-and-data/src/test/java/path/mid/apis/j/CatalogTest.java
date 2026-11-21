
package path.mid.apis.j;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CatalogTest {

    @Test
    void jsonAndRepository() throws Exception {
        try (var in = CatalogTest.class.getResourceAsStream("/books.json")) {
            List<Book> books = JsonCatalog.load(in);
            assertThat(books).hasSize(3);
            assertThat(books.get(0).title()).isEqualTo("Effective Java");
            InMemoryBookRepository repo = new InMemoryBookRepository();
            books.forEach(repo::save);
            assertThat(repo.findByIsbn("978-2")).contains(books.get(1));
        }
    }

    @Test
    void serviceUsesClient() {
        FakeBookClient client = new FakeBookClient(List.of(
                new BookJson("1", "A", "Ada", 10),
                new BookJson("2", "B", "Alan", 10),
                new BookJson("3", "C", "Ada", 10)
        ));
        assertThat(new CatalogService(client).titlesForAuthor("ada")).containsExactly("A", "C");
    }
}
