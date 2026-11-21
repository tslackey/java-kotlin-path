
package path.aoc.gym.j;

import java.util.List;

public final class MergeWindows {
    private MergeWindows() {}

    public record Window(int start, int end) {}

    /** Inclusive-exclusive [start, end). Merge overlaps; sort by start. */
    public static List<Window> merge(List<Window> windows) {
        throw new UnsupportedOperationException("Implement me");
    }
}
