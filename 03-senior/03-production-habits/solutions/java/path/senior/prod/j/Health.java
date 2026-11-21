
package path.senior.prod.j;

public final class Health {
    private Health() {}

    public static String body(AppConfig config) {
        return "{\"status\":\"ok\",\"env\":\"" + config.env() + "\"}";
    }
}
