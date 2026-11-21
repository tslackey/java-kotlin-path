
package path.aoc.gym.j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MergeWindows {
    private MergeWindows() {}

    public record Window(int start, int end) {}

    public static List<Window> merge(List<Window> windows) {
        if (windows.isEmpty()) {
            return List.of();
        }
        List<Window> sorted = new ArrayList<>(windows);
        sorted.sort(Comparator.comparingInt(Window::start));
        List<Window> out = new ArrayList<>();
        Window cur = sorted.get(0);
        for (int i = 1; i < sorted.size(); i++) {
            Window next = sorted.get(i);
            if (next.start() <= cur.end()) {
                cur = new Window(cur.start(), Math.max(cur.end(), next.end()));
            } else {
                out.add(cur);
                cur = next;
            }
        }
        out.add(cur);
        return List.copyOf(out);
    }
}
