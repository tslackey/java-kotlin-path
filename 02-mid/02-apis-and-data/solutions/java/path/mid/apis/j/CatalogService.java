
package path.mid.apis.j;

import java.util.List;
import java.util.Locale;

public final class CatalogService {
    private final BookClient client;

    public CatalogService(BookClient client) {
        this.client = client;
    }

    public List<String> titlesForAuthor(String author) {
        String needle = author.toLowerCase(Locale.ROOT);
        return client.fetchAll().stream()
                .filter(book -> book.author().toLowerCase(Locale.ROOT).equals(needle))
                .map(BookJson::title)
                .toList();
    }
}
