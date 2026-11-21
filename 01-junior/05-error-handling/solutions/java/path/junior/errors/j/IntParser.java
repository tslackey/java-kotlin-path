
package path.junior.errors.j;

import java.util.ArrayList;
import java.util.List;

public final class IntParser {
    private IntParser() {}

    public static ParseOutcome parse(List<String> lines) {
        List<Integer> values = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            try {
                values.add(Integer.parseInt(line.trim()));
            } catch (NumberFormatException ex) {
                errors.add("line " + (i + 1) + ": '" + line + "'");
            }
        }
        return new ParseOutcome(List.copyOf(values), List.copyOf(errors));
    }

    public record ParseOutcome(List<Integer> values, List<String> errors) {}
}
