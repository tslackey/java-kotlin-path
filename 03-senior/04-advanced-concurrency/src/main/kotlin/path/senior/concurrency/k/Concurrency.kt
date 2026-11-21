
package path.senior.concurrency.k

class SafeAccount(cents: Int) {
    var cents: Int = cents
        private set

    fun withdraw(amount: Int) {
        TODO("Implement me")
    }
}

class RateLimiter(
    private val limit: Int,
    private val windowMillis: Long,
    private val clock: () -> Long,
) {
    fun tryAcquire(): Boolean {
        TODO("Implement me")
    }
}

object CancellableWork {
    suspend fun runUntilCancelled(onTick: suspend () -> Unit) {
        TODO("Implement me")
    }
}
