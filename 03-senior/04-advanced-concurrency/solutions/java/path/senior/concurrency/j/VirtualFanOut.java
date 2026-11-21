
package path.senior.concurrency.j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class VirtualFanOut {
    private VirtualFanOut() {}

    public static int sum(List<Callable<Integer>> tasks) throws Exception {
        try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<Integer>> futures = new ArrayList<>();
            for (Callable<Integer> task : tasks) {
                futures.add(pool.submit(task));
            }
            int total = 0;
            for (Future<Integer> future : futures) {
                total += future.get();
            }
            return total;
        }
    }
}
