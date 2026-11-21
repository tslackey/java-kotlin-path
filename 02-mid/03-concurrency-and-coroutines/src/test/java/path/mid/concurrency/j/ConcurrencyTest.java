
package path.mid.concurrency.j;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConcurrencyTest {

    @Test
    void parallelMapPreservesOrder() throws Exception {
        try (var pool = Executors.newFixedThreadPool(4)) {
            List<Integer> out = ParallelMapper.map(pool, List.of(1, 2, 3, 4), n -> n * n);
            assertThat(out).containsExactly(1, 4, 9, 16);
        }
    }

    @Test
    void futurePipeline() throws Exception {
        try (var pool = Executors.newSingleThreadExecutor()) {
            assertThat(Futures.plusOneThenString(pool, 41).get()).isEqualTo("42");
        }
    }

    @Test
    void counterIsSafe() throws Exception {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        try (var pool = Executors.newFixedThreadPool(8)) {
            var tasks = IntStream.range(0, 10_000)
                    .mapToObj(i -> pool.submit(counter::increment))
                    .toList();
            for (var task : tasks) {
                task.get();
            }
        }
        assertThat(counter.get()).isEqualTo(10_000);
    }
}
