package path.junior.fundamentals.j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EqualityTest {

    @Test
    void internedLiteralsShareAReference() {
        String a = "path";
        String b = "path";
        assertThat(Equality.sameReference(a, b)).isTrue();
        assertThat(Equality.valueEqual(a, b)).isTrue();
    }

    @Test
    void constructedStringsAreEqualButNotTheSameReference() {
        String a = "path";
        String b = new String("path");
        assertThat(Equality.valueEqual(a, b)).isTrue();
        assertThat(Equality.sameReference(a, b)).isFalse();
    }

    @Test
    void nullSafeValueEquality() {
        assertThat(Equality.valueEqual(null, null)).isTrue();
        assertThat(Equality.valueEqual(null, "x")).isFalse();
    }
}
