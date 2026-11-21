
package path.senior.prod.j;

import java.util.Map;

public record AppConfig(int port, String env) {
    public static AppConfig load(Map<String, String> env) {
        String portRaw = env.getOrDefault("APP_PORT", "8081");
        int port;
        try {
            port = Integer.parseInt(portRaw);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("APP_PORT");
        }
        String environment = env.getOrDefault("APP_ENV", "dev");
        if (environment.isBlank()) {
            environment = "dev";
        }
        return new AppConfig(port, environment);
    }
}
