
package path.junior.collections.j;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public final class WordFrequency {
    private WordFrequency() {}

    public static Map<String, Long> count(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text");
        }
        return Arrays.stream(text.toLowerCase().split("[^a-z]+"))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
