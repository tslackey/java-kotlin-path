
package path.mid.gradle.j;

public final class TodoCounter {
    private TodoCounter() {}

    public static int count(String source) {
        if (source == null || source.isEmpty()) {
            return 0;
        }
        int count = 0;
        int from = 0;
        while (true) {
            int at = source.indexOf("TODO", from);
            if (at < 0) {
                return count;
            }
            count++;
            from = at + 4;
        }
    }
}
