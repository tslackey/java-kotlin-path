
package path.mid.apis.j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class JsonCatalog {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonCatalog() {}

    public static List<Book> load(InputStream json) throws IOException {
        List<BookJson> rows = MAPPER.readValue(json, new TypeReference<>() {});
        return rows.stream().map(BookMapper::toDomain).toList();
    }
}
