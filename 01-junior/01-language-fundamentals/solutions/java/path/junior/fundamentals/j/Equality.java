package path.junior.fundamentals.j;

import java.util.Objects;

public final class Equality {
    private Equality() {}

    public static boolean valueEqual(String a, String b) {
        return Objects.equals(a, b);
    }

    public static boolean sameReference(Object a, Object b) {
        return a == b;
    }
}
