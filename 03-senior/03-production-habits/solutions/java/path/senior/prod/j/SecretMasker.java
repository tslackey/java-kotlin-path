
package path.senior.prod.j;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class SecretMasker {
    private SecretMasker() {}

    public static Map<String, String> mask(Map<String, String> input) {
        Map<String, String> out = new LinkedHashMap<>();
        for (var e : input.entrySet()) {
            String key = e.getKey().toLowerCase(Locale.ROOT);
            boolean secret = key.contains("token") || key.contains("password") || key.contains("secret");
            out.put(e.getKey(), secret ? "***" : e.getValue());
        }
        return Map.copyOf(out);
    }
}
