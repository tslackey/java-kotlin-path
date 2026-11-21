
package path.junior.collections.j;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public final class Uniques {
    private Uniques() {}

    public static <T> List<T> preserveOrder(List<T> items) {
        return new ArrayList<>(new LinkedHashSet<>(items));
    }
}
