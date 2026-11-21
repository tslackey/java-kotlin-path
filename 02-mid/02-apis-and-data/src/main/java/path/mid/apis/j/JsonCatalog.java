
package path.mid.apis.j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class JsonCatalog {
    private JsonCatalog() {}

    public static List<Book> load(InputStream json) throws IOException {
        throw new UnsupportedOperationException("Implement me");
    }
}
