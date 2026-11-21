
package path.senior.concurrency.j;

import java.util.function.LongSupplier;

public final class RateLimiter {
    private final int limit;
    private final long windowMillis;
    private final LongSupplier clock;

    public RateLimiter(int limit, long windowMillis, LongSupplier clock) {
        this.limit = limit;
        this.windowMillis = windowMillis;
        this.clock = clock;
    }

    public synchronized boolean tryAcquire() {
        throw new UnsupportedOperationException("Implement me");
    }
}
