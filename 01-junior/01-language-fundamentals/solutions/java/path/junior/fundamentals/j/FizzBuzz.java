package path.junior.fundamentals.j;

import java.util.ArrayList;
import java.util.List;

public final class FizzBuzz {
    private FizzBuzz() {}

    public static String of(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        }
        if (n % 3 == 0) {
            return "Fizz";
        }
        if (n % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(n);
    }

    public static List<String> sequence(int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("to < from");
        }
        List<String> out = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            out.add(of(i));
        }
        return List.copyOf(out);
    }
}
