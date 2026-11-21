
package path.mid.concurrency.k

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConcurrencyTest {

    @Test
    fun parallelMapPreservesOrder() = runBlocking {
        val out = CoroutineMapper.map(listOf(1, 2, 3, 4)) { it * it }
        assertThat(out).containsExactly(1, 4, 9, 16)
    }

    @Test
    fun counterIsSafe() = runBlocking {
        val counter = ThreadSafeCounter()
        withContext(Dispatchers.Default) {
            repeat(10_000) {
                launch { counter.increment() }
            }
        }
        assertThat(counter.get()).isEqualTo(10_000)
    }
}
