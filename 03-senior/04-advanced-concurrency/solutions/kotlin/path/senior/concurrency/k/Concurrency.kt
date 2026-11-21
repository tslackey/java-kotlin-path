
package path.senior.concurrency.k

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.yield

class SafeAccount(cents: Int) {
    var cents: Int = cents
        private set

    @Synchronized
    fun withdraw(amount: Int) {
        require(amount >= 0) { "amount" }
        check(amount <= cents) { "insufficient" }
        cents -= amount
    }
}

class RateLimiter(
    private val limit: Int,
    private val windowMillis: Long,
    private val clock: () -> Long,
) {
    private var windowStart = clock()
    private var used = 0

    @Synchronized
    fun tryAcquire(): Boolean {
        val now = clock()
        if (now - windowStart >= windowMillis) {
            windowStart = now
            used = 0
        }
        if (used >= limit) return false
        used++
        return true
    }
}

object CancellableWork {
    suspend fun runUntilCancelled(onTick: suspend () -> Unit) {
        coroutineScope {
            while (true) {
                ensureActive()
                onTick()
                yield()
            }
        }
    }
}
