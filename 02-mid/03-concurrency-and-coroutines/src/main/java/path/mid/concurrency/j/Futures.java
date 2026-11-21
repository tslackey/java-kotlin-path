
package path.mid.concurrency.j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public final class Futures {
    private Futures() {}

    /**
     * Asynchronously add one to {@code n}, then stringify. Do not block the caller.
     */
    public static CompletableFuture<String> plusOneThenString(Executor executor, int n) {
        throw new UnsupportedOperationException("Implement me");
    }
}
