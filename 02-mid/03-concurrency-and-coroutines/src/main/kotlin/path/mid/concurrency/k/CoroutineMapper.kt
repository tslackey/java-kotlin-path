
package path.mid.concurrency.k

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object CoroutineMapper {
    suspend fun <T, R> map(
        inputs: List<T>,
        context: CoroutineContext = Dispatchers.Default,
        fn: suspend (T) -> R,
    ): List<R> {
        TODO("Implement me")
    }
}
