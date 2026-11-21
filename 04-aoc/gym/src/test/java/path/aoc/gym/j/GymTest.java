package path.aoc.gym.j;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GymTest {

    @Test
    void altitude() {
        assertThat(AltitudeLog.net("UUD")).isEqualTo(1);
        assertThat(AltitudeLog.firstBelowSea("D")).isEqualTo(1);
        assertThat(AltitudeLog.firstBelowSea("UDD")).isEqualTo(3);
        assertThat(AltitudeLog.firstBelowSea("UU")).isEqualTo(-1);
    }

    @Test
    void receipts() {
        String input = "1\n2\n\n3\n4\n5\n\n6\n";
        assertThat(ReceiptBatches.maxBatch(input)).isEqualTo(12);
        assertThat(ReceiptBatches.topThreeSum(input)).isEqualTo(21);
    }

    @Test
    void reachable() {
        String grid = ".S.#\n..#.\n.#..";
        assertThat(ReachableCells.count(grid)).isEqualTo(6);
    }

    @Test
    void merge() {
        assertThat(MergeWindows.merge(List.of(
                new MergeWindows.Window(1, 3),
                new MergeWindows.Window(2, 6),
                new MergeWindows.Window(8, 10)
        ))).containsExactly(
                new MergeWindows.Window(1, 6),
                new MergeWindows.Window(8, 10)
        );
    }

    @Test
    void climb() {
        String grid = "116\n138\n213";
        assertThat(CheapestClimb.minCost(grid)).isEqualTo(8);
    }
}
