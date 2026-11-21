
package path.junior.nullsafety.j;

import java.util.Map;
import java.util.Optional;

public final class Directory {
    private final Map<String, User> users;

    public Directory(Map<String, User> users) {
        this.users = Map.copyOf(users);
    }

    public Optional<User> find(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(users.get(id));
    }

    public String displayName(String id) {
        return find(id)
                .map(User::name)
                .filter(name -> name != null && !name.isBlank())
                .orElse("Unknown");
    }

    public static Optional<Integer> parsePositiveInt(String raw) {
        if (raw == null || raw.isBlank()) {
            return Optional.empty();
        }
        try {
            int value = Integer.parseInt(raw.trim());
            return value > 0 ? Optional.of(value) : Optional.empty();
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }
}
