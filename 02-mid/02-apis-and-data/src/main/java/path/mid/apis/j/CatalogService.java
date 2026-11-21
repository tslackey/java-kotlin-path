
package path.mid.apis.j;

import java.util.List;

public final class CatalogService {
    private final BookClient client;

    public CatalogService(BookClient client) {
        this.client = client;
    }

    public List<String> titlesForAuthor(String author) {
        throw new UnsupportedOperationException("Implement me");
    }
}
