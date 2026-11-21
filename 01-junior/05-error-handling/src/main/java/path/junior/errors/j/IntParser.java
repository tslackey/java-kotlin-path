
package path.junior.errors.j;

import java.util.List;

public final class IntParser {
    private IntParser() {}

    /**
     * Each input line is parsed independently. Invalid lines become an error
     * message in {@link ParseOutcome#errors()} and are omitted from values.
     */
    public static ParseOutcome parse(List<String> lines) {
        throw new UnsupportedOperationException("Implement me");
    }

    public record ParseOutcome(List<Integer> values, List<String> errors) {}
}
