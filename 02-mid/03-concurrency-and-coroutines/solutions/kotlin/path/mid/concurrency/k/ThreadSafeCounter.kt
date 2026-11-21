
package path.mid.concurrency.k

import java.util.concurrent.atomic.AtomicInteger

class ThreadSafeCounter {
    private val value = AtomicInteger()

    fun increment() {
        value.incrementAndGet()
    }

    fun get(): Int = value.get()
}
