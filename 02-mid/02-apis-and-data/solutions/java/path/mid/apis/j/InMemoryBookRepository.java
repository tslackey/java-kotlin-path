
package path.mid.apis.j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> byIsbn = new LinkedHashMap<>();

    @Override
    public void save(Book book) {
        byIsbn.put(book.isbn(), book);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(byIsbn.get(isbn));
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(byIsbn.values());
    }
}
