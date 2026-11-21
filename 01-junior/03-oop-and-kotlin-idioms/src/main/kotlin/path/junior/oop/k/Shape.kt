
package path.junior.oop.k

sealed class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = TODO("Implement me")
    override fun perimeter(): Double = TODO("Implement me")
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double = TODO("Implement me")
    override fun perimeter(): Double = TODO("Implement me")
}

fun List<Shape>.totalArea(): Double = TODO("Implement me")
