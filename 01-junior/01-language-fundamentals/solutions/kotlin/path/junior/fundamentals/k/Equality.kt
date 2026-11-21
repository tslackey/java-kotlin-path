package path.junior.fundamentals.k

object Equality {
    fun valueEqual(a: String?, b: String?): Boolean = a == b

    fun sameReference(a: Any?, b: Any?): Boolean = a === b
}
