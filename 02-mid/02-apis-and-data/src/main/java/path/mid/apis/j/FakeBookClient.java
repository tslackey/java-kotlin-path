
package path.mid.apis.j;

import java.util.List;

public final class FakeBookClient implements BookClient {
    private final List<BookJson> payload;

    public FakeBookClient(List<BookJson> payload) {
        this.payload = List.copyOf(payload);
    }

    @Override
    public List<BookJson> fetchAll() {
        return payload;
    }
}
