
package path.mid.concurrency.j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

public final class ParallelMapper {
    private ParallelMapper() {}

    public static <T, R> List<R> map(ExecutorService pool, List<T> inputs, Function<T, R> fn)
            throws Exception {
        throw new UnsupportedOperationException("Implement me");
    }
}
