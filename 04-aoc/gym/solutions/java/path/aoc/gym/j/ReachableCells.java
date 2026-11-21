
package path.aoc.gym.j;

import java.util.ArrayDeque;

public final class ReachableCells {
    private ReachableCells() {}

    public static int count(String grid) {
        String[] rows = grid.strip().split("\\R");
        int h = rows.length;
        int w = rows[0].length();
        int sr = 0;
        int sc = 0;
        for (int r = 0; r < h; r++) {
            int c = rows[r].indexOf('S');
            if (c >= 0) {
                sr = r;
                sc = c;
            }
        }
        boolean[][] seen = new boolean[h][w];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sr, sc});
        seen[sr][sc] = true;
        int n = 0;
        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] p = q.removeFirst();
            n++;
            for (int[] step : d) {
                int rr = p[0] + step[0];
                int cc = p[1] + step[1];
                if (rr < 0 || cc < 0 || rr >= h || cc >= w || seen[rr][cc]) {
                    continue;
                }
                char ch = rows[rr].charAt(cc);
                if (ch == '#') {
                    continue;
                }
                seen[rr][cc] = true;
                q.add(new int[] {rr, cc});
            }
        }
        return n;
    }
}
