
package path.junior.oop.j;

public final class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
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
