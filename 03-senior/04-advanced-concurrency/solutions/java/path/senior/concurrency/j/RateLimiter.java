
package path.senior.concurrency.j;

import java.util.function.LongSupplier;

public final class RateLimiter {
    private final int limit;
    private final long windowMillis;
    private final LongSupplier clock;
    private long windowStart;
    private int used;

    public RateLimiter(int limit, long windowMillis, LongSupplier clock) {
        this.limit = limit;
        this.windowMillis = windowMillis;
        this.clock = clock;
        this.windowStart = clock.getAsLong();
    }

    public synchronized boolean tryAcquire() {
        long now = clock.getAsLong();
        if (now - windowStart >= windowMillis) {
            windowStart = now;
            used = 0;
        }
        if (used >= limit) {
            return false;
        }
        used++;
        return true;
    }
}
