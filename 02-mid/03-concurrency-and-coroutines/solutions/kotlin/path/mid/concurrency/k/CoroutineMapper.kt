
package path.mid.concurrency.k

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object CoroutineMapper {
    suspend fun <T, R> map(
        inputs: List<T>,
        context: CoroutineContext = Dispatchers.Default,
        fn: suspend (T) -> R,
    ): List<R> = coroutineScope {
        inputs.map { input ->
            async(context) { fn(input) }
        }.awaitAll()
    }
}
