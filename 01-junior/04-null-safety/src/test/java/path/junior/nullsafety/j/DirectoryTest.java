
package path.junior.nullsafety.j;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DirectoryTest {

    private final Directory directory = new Directory(Map.of(
            "1", new User("1", "Ada"),
            "2", new User("2", "  "),
            "3", new User("3", null)
    ));

    @Test
    void find() {
        assertThat(directory.find("1")).contains(new User("1", "Ada"));
        assertThat(directory.find("missing")).isEmpty();
        assertThat(directory.find(null)).isEmpty();
    }

    @Test
    void displayName() {
        assertThat(directory.displayName("1")).isEqualTo("Ada");
        assertThat(directory.displayName("2")).isEqualTo("Unknown");
        assertThat(directory.displayName("3")).isEqualTo("Unknown");
        assertThat(directory.displayName("nope")).isEqualTo("Unknown");
    }

    @Test
    void parsePositiveInt() {
        assertThat(Directory.parsePositiveInt("42")).contains(42);
        assertThat(Directory.parsePositiveInt(" 7 ")).contains(7);
        assertThat(Directory.parsePositiveInt("0")).isEmpty();
        assertThat(Directory.parsePositiveInt("-3")).isEmpty();
        assertThat(Directory.parsePositiveInt("no")).isEmpty();
        assertThat(Directory.parsePositiveInt(null)).isEmpty();
    }
}
