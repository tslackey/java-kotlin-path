
package path.senior.concurrency.j;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConcurrencyTest {

    @Test
    void accountSurvivesParallelWithdrawals() throws Exception {
        SafeAccount account = new SafeAccount(10_000);
        try (var pool = Executors.newFixedThreadPool(8)) {
            var tasks = IntStream.range(0, 10_000)
                    .mapToObj(i -> pool.submit(() -> account.withdraw(1)))
                    .toList();
            for (var t : tasks) {
                t.get();
            }
        }
        assertThat(account.cents()).isZero();
    }

    @Test
    void rateLimiterWindow() {
        AtomicLong now = new AtomicLong(0);
        RateLimiter limiter = new RateLimiter(2, 100, now::get);
        assertThat(limiter.tryAcquire()).isTrue();
        assertThat(limiter.tryAcquire()).isTrue();
        assertThat(limiter.tryAcquire()).isFalse();
        now.set(100);
        assertThat(limiter.tryAcquire()).isTrue();
    }

    @Test
    void virtualFanOutSums() throws Exception {
        List<Callable<Integer>> tasks = List.of(() -> 1, () -> 2, () -> 3);
        assertThat(VirtualFanOut.sum(tasks)).isEqualTo(6);
    }
}
