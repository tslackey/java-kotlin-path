
package path.mid.concurrency.j;

import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadSafeCounter {
    private final AtomicInteger value = new AtomicInteger();

    public void increment() {
        value.incrementAndGet();
    }

    public int get() {
        return value.get();
    }
}
