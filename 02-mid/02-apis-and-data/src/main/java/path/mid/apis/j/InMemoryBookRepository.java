
package path.mid.apis.j;

import java.util.List;
import java.util.Optional;

public final class InMemoryBookRepository implements BookRepository {
    @Override
    public void save(Book book) {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public List<Book> findAll() {
        throw new UnsupportedOperationException("Implement me");
    }
}
