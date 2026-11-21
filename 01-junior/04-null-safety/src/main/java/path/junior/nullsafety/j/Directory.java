
package path.junior.nullsafety.j;

import java.util.Map;
import java.util.Optional;

public final class Directory {
    private final Map<String, User> users;

    public Directory(Map<String, User> users) {
        this.users = Map.copyOf(users);
    }

    public Optional<User> find(String id) {
        throw new UnsupportedOperationException("Implement me");
    }

    public String displayName(String id) {
        throw new UnsupportedOperationException("Implement me");
    }

    public static Optional<Integer> parsePositiveInt(String raw) {
        throw new UnsupportedOperationException("Implement me");
    }
}
