
package path.aoc.gym.j;

public final class AltitudeLog {
    private AltitudeLog() {}

    public static int net(String steps) {
        int alt = 0;
        for (int i = 0; i < steps.length(); i++) {
            alt += steps.charAt(i) == 'U' ? 1 : -1;
        }
        return alt;
    }

    public static int firstBelowSea(String steps) {
        int alt = 0;
        for (int i = 0; i < steps.length(); i++) {
            alt += steps.charAt(i) == 'U' ? 1 : -1;
            if (alt < 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
