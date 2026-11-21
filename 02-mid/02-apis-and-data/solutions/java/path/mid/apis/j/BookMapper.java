
package path.mid.apis.j;

import java.util.Objects;

public final class BookMapper {
    private BookMapper() {}

    public static Book toDomain(BookJson json) {
        Objects.requireNonNull(json, "json");
        return new Book(json.isbn(), json.title(), json.author(), json.pages());
    }
}
