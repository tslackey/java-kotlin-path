
package path.senior.prod.j;

import java.util.Map;

public record AppConfig(int port, String env) {
    public static AppConfig load(Map<String, String> env) {
        throw new UnsupportedOperationException("Implement me");
    }
}
