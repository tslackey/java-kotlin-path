
package path.junior.oop.j;

import java.util.List;

public final class Shapes {
    private Shapes() {}

    public static double totalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }
}
