
package path.junior.oop.j;

public final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public double perimeter() {
        throw new UnsupportedOperationException("Implement me");
    }
}
