
package path.mid.concurrency.j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public final class Futures {
    private Futures() {}

    public static CompletableFuture<String> plusOneThenString(Executor executor, int n) {
        return CompletableFuture.supplyAsync(() -> n + 1, executor)
                .thenApplyAsync(Object::toString, executor);
    }
}
