
package path.junior.oop.k

sealed class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Circle(val radius: Double) : Shape() {
    init {
        require(radius >= 0) { "radius" }
    }

    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    init {
        require(width >= 0 && height >= 0) { "size" }
    }

    override fun area(): Double = width * height
    override fun perimeter(): Double = 2 * (width + height)
}

fun List<Shape>.totalArea(): Double = sumOf { it.area() }
