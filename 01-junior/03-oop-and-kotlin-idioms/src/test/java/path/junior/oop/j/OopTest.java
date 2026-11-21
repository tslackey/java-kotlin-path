
package path.junior.oop.j;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

class OopTest {

    @Test
    void circleAndRectangle() {
        assertThat(new Circle(2).area()).isCloseTo(Math.PI * 4, within(1e-9));
        assertThat(new Circle(2).perimeter()).isCloseTo(4 * Math.PI, within(1e-9));
        assertThat(new Rectangle(3, 4).area()).isEqualTo(12.0);
        assertThat(new Rectangle(3, 4).perimeter()).isEqualTo(14.0);
        assertThat(Shapes.totalArea(List.of(new Rectangle(2, 2), new Rectangle(1, 1)))).isEqualTo(5.0);
    }

    @Test
    void moneyAddsSameCurrency() {
        assertThat(new Money("USD", 199).plus(new Money("USD", 1))).isEqualTo(new Money("USD", 200));
        assertThatThrownBy(() -> new Money("USD", 1).plus(new Money("EUR", 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
