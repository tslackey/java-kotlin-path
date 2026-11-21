package path.aoc.gym.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GymTest {

    @Test
    fun altitude() {
        assertThat(AltitudeLog.net("UUD")).isEqualTo(1)
        assertThat(AltitudeLog.firstBelowSea("D")).isEqualTo(1)
        assertThat(AltitudeLog.firstBelowSea("UDD")).isEqualTo(3)
        assertThat(AltitudeLog.firstBelowSea("UU")).isEqualTo(-1)
    }

    @Test
    fun receipts() {
        val input = "1\n2\n\n3\n4\n5\n\n6\n"
        assertThat(ReceiptBatches.maxBatch(input)).isEqualTo(12)
        assertThat(ReceiptBatches.topThreeSum(input)).isEqualTo(21)
    }

    @Test
    fun reachable() {
        val grid = ".S.#\n..#.\n.#.."
        assertThat(ReachableCells.count(grid)).isEqualTo(6)
    }

    @Test
    fun merge() {
        assertThat(
            MergeWindows.merge(
                listOf(Window(1, 3), Window(2, 6), Window(8, 10)),
            ),
        ).containsExactly(Window(1, 6), Window(8, 10))
    }

    @Test
    fun climb() {
        assertThat(CheapestClimb.minCost("116\n138\n213")).isEqualTo(8)
    }
}
