
package path.senior.concurrency.j;

import java.util.List;
import java.util.concurrent.Callable;

public final class VirtualFanOut {
    private VirtualFanOut() {}

    public static int sum(List<Callable<Integer>> tasks) throws Exception {
        throw new UnsupportedOperationException("Implement me");
    }
}
