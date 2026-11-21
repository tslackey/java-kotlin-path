package path.junior.fundamentals.j;

public final class Numbers {
    private Numbers() {}

    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be 0..20");
        }
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int clamp(int value, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min > max");
        }
        return Math.max(min, Math.min(max, value));
    }
}
