
package path.senior.perf.j;

import java.util.HashMap;
import java.util.Map;

public final class TwoSum {
    private TwoSum() {}

    public static int[] indices(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer other = seen.get(target - nums[i]);
            if (other != null) {
                return new int[] {other, i};
            }
            seen.putIfAbsent(nums[i], i);
        }
        throw new IllegalArgumentException("no pair");
    }
}
