
package path.junior.nullsafety.k

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DirectoryTest {

    private val directory = Directory(
        mapOf(
            "1" to User("1", "Ada"),
            "2" to User("2", "  "),
            "3" to User("3", null),
        ),
    )

    @Test
    fun find() {
        assertThat(directory.find("1")).isEqualTo(User("1", "Ada"))
        assertThat(directory.find("missing")).isNull()
        assertThat(directory.find(null)).isNull()
    }

    @Test
    fun displayName() {
        assertThat(directory.displayName("1")).isEqualTo("Ada")
        assertThat(directory.displayName("2")).isEqualTo("Unknown")
        assertThat(directory.displayName("3")).isEqualTo("Unknown")
        assertThat(directory.displayName("nope")).isEqualTo("Unknown")
    }

    @Test
    fun parsePositiveInt() {
        assertThat(Directory.parsePositiveInt("42")).isEqualTo(42)
        assertThat(Directory.parsePositiveInt(" 7 ")).isEqualTo(7)
        assertThat(Directory.parsePositiveInt("0")).isNull()
        assertThat(Directory.parsePositiveInt("-3")).isNull()
        assertThat(Directory.parsePositiveInt("no")).isNull()
        assertThat(Directory.parsePositiveInt(null)).isNull()
    }
}
