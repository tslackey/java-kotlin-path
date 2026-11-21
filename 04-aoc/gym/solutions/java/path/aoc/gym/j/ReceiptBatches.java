
package path.aoc.gym.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ReceiptBatches {
    private ReceiptBatches() {}

    public static int maxBatch(String input) {
        return sums(input).stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static int topThreeSum(String input) {
        List<Integer> sums = sums(input);
        sums.sort(Collections.reverseOrder());
        return sums.stream().limit(3).mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> sums(String input) {
        List<Integer> out = new ArrayList<>();
        int current = 0;
        boolean inBatch = false;
        for (String line : input.split("\\R", -1)) {
            if (line.isBlank()) {
                if (inBatch) {
                    out.add(current);
                    current = 0;
                    inBatch = false;
                }
            } else {
                current += Integer.parseInt(line.trim());
                inBatch = true;
            }
        }
        if (inBatch) {
            out.add(current);
        }
        return out;
    }
}
