
package path.junior.collections.k

object Catalog {
    fun inStock(items: List<Item>): List<Item> = items.filter { it.inStock }

    fun totalCentsInStock(items: List<Item>): Int =
        items.filter { it.inStock }.sumOf { it.cents }

    fun byDepartment(items: List<Item>): Map<String, List<Item>> = items.groupBy { it.department }
}
