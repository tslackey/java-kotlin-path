
package path.senior.perf.j;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Uniques {
    private Uniques() {}

    public static Set<Integer> duplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dupes = new LinkedHashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) {
                dupes.add(n);
            }
        }
        return Set.copyOf(dupes);
    }
}
