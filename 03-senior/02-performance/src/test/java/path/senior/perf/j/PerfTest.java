
package path.senior.perf.j;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class PerfTest {

    @Test
    void twoSumSmall() {
        assertThat(TwoSum.indices(new int[] {2, 7, 11, 15}, 9)).containsExactly(0, 1);
        assertThat(TwoSum.indices(new int[] {3, 2, 4}, 6)).containsExactly(1, 2);
    }

    @Test
    void twoSumLarge() {
        int n = 80_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        nums[n - 1] = 1_000_000;
        nums[n - 2] = 2_000_000;
        long start = System.nanoTime();
        int[] hit = TwoSum.indices(nums, 3_000_000);
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertThat(hit).containsExactly(n - 2, n - 1);
        assertThat(ms).as("two-sum should be near-linear, was %s ms", ms).isLessThan(800);
    }

    @Test
    void duplicatesAndJoin() {
        assertThat(Uniques.duplicates(new int[] {1, 2, 1, 3, 2, 2})).containsExactly(1, 2);
        assertThat(Joiner.join(List.of("a", "b", "c"), ",")).isEqualTo("a,b,c");
        List<String> many = IntStream.range(0, 20_000).mapToObj(i -> "x").toList();
        long start = System.nanoTime();
        String joined = Joiner.join(many, "");
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertThat(joined).hasSize(20_000);
        assertThat(ms).as("join should not be quadratic, was %s ms", ms).isLessThan(800);
    }
}
