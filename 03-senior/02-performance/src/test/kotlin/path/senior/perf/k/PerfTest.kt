
package path.senior.perf.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PerfTest {

    @Test
    fun twoSumSmall() {
        assertThat(TwoSum.indices(intArrayOf(2, 7, 11, 15), 9)).containsExactly(0, 1)
        assertThat(TwoSum.indices(intArrayOf(3, 2, 4), 6)).containsExactly(1, 2)
    }

    @Test
    fun twoSumLarge() {
        val n = 80_000
        val nums = IntArray(n) { it }
        nums[n - 1] = 1_000_000
        nums[n - 2] = 2_000_000
        val start = System.nanoTime()
        val hit = TwoSum.indices(nums, 3_000_000)
        val ms = (System.nanoTime() - start) / 1_000_000
        assertThat(hit).containsExactly(n - 2, n - 1)
        assertThat(ms).`as`("two-sum should be near-linear, was %s ms", ms).isLessThan(800)
    }

    @Test
    fun duplicatesAndJoin() {
        assertThat(Uniques.duplicates(intArrayOf(1, 2, 1, 3, 2, 2))).containsExactly(1, 2)
        assertThat(Joiner.join(listOf("a", "b", "c"), ",")).isEqualTo("a,b,c")
        val many = List(20_000) { "x" }
        val start = System.nanoTime()
        val joined = Joiner.join(many, "")
        val ms = (System.nanoTime() - start) / 1_000_000
        assertThat(joined).hasSize(20_000)
        assertThat(ms).`as`("join should not be quadratic, was %s ms", ms).isLessThan(800)
    }
}
