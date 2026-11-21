
package path.senior.concurrency.k

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

class ConcurrencyTest {

    @Test
    fun accountSurvivesParallelWithdrawals() {
        val account = SafeAccount(10_000)
        Executors.newFixedThreadPool(8).use { pool ->
            val tasks = (1..10_000).map { pool.submit { account.withdraw(1) } }
            tasks.forEach { it.get() }
        }
        assertThat(account.cents).isZero()
    }

    @Test
    fun rateLimiterWindow() {
        val now = AtomicLong(0)
        val limiter = RateLimiter(2, 100) { now.get() }
        assertThat(limiter.tryAcquire()).isTrue()
        assertThat(limiter.tryAcquire()).isTrue()
        assertThat(limiter.tryAcquire()).isFalse()
        now.set(100)
        assertThat(limiter.tryAcquire()).isTrue()
    }

    @Test
    fun cancelStopsWork() = runBlocking {
        val ticks = AtomicInteger()
        val job = launch(Dispatchers.Default) {
            CancellableWork.runUntilCancelled { ticks.incrementAndGet() }
        }
        withTimeout(2_000) {
            while (ticks.get() < 5) {
                // wait until it has actually started
            }
            job.cancelAndJoin()
        }
        val after = ticks.get()
        Thread.sleep(50)
        assertThat(ticks.get()).isEqualTo(after)
        assertThat(after).isGreaterThanOrEqualTo(5)
    }
}
