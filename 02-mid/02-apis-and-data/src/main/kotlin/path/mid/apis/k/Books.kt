
package path.mid.apis.k

data class BookJson(val isbn: String, val title: String, val author: String, val pages: Int)

data class Book(val isbn: String, val title: String, val author: String, val pages: Int)

object BookMapper {
    fun toDomain(json: BookJson): Book {
        TODO("Implement me")
    }
}

object JsonCatalog {
    fun load(json: java.io.InputStream): List<Book> {
        TODO("Implement me")
    }
}

interface BookRepository {
    fun save(book: Book)
    fun findByIsbn(isbn: String): Book?
    fun findAll(): List<Book>
}

class InMemoryBookRepository : BookRepository {
    override fun save(book: Book) {
        TODO("Implement me")
    }

    override fun findByIsbn(isbn: String): Book? {
        TODO("Implement me")
    }

    override fun findAll(): List<Book> {
        TODO("Implement me")
    }
}

fun interface BookClient {
    fun fetchAll(): List<BookJson>
}

class FakeBookClient(private val payload: List<BookJson>) : BookClient {
    override fun fetchAll(): List<BookJson> = payload
}

class CatalogService(private val client: BookClient) {
    fun titlesForAuthor(author: String): List<String> {
        TODO("Implement me")
    }
}
