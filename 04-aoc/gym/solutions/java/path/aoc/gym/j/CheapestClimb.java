
package path.aoc.gym.j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class CheapestClimb {
    private CheapestClimb() {}

    public static int minCost(String grid) {
        String[] rows = grid.strip().split("\\R");
        int h = rows.length;
        int w = rows[0].length();
        int[][] cost = new int[h][w];
        for (int r = 0; r < h; r++) {
            Arrays.fill(cost[r], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int start = rows[0].charAt(0) - '0';
        cost[0][0] = start;
        pq.add(new int[] {start, 0, 0});
        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int c = cur[0];
            int r = cur[1];
            int col = cur[2];
            if (c != cost[r][col]) {
                continue;
            }
            if (r == h - 1 && col == w - 1) {
                return c;
            }
            for (int[] step : d) {
                int rr = r + step[0];
                int cc = col + step[1];
                if (rr < 0 || cc < 0 || rr >= h || cc >= w) {
                    continue;
                }
                int next = c + (rows[rr].charAt(cc) - '0');
                if (next < cost[rr][cc]) {
                    cost[rr][cc] = next;
                    pq.add(new int[] {next, rr, cc});
                }
            }
        }
        throw new IllegalStateException("unreachable");
    }
}
