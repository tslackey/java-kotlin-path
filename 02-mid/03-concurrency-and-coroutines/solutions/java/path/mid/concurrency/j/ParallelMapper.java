
package path.mid.concurrency.j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Function;

public final class ParallelMapper {
    private ParallelMapper() {}

    public static <T, R> List<R> map(ExecutorService pool, List<T> inputs, Function<T, R> fn)
            throws Exception {
        List<Future<R>> futures = new ArrayList<>();
        for (T input : inputs) {
            futures.add(pool.submit(() -> fn.apply(input)));
        }
        List<R> out = new ArrayList<>(futures.size());
        for (Future<R> future : futures) {
            out.add(future.get());
        }
        return List.copyOf(out);
    }
}
