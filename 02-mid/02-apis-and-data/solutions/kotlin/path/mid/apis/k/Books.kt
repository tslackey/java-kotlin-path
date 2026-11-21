
package path.mid.apis.k

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.InputStream

data class BookJson(val isbn: String, val title: String, val author: String, val pages: Int)

data class Book(val isbn: String, val title: String, val author: String, val pages: Int)

object BookMapper {
    fun toDomain(json: BookJson): Book = Book(json.isbn, json.title, json.author, json.pages)
}

object JsonCatalog {
    private val mapper = jacksonObjectMapper()

    fun load(json: InputStream): List<Book> {
        val rows: List<BookJson> = mapper.readValue(json)
        return rows.map(BookMapper::toDomain)
    }
}

interface BookRepository {
    fun save(book: Book)
    fun findByIsbn(isbn: String): Book?
    fun findAll(): List<Book>
}

class InMemoryBookRepository : BookRepository {
    private val byIsbn = linkedMapOf<String, Book>()

    override fun save(book: Book) {
        byIsbn[book.isbn] = book
    }

    override fun findByIsbn(isbn: String): Book? = byIsbn[isbn]

    override fun findAll(): List<Book> = byIsbn.values.toList()
}

fun interface BookClient {
    fun fetchAll(): List<BookJson>
}

class FakeBookClient(private val payload: List<BookJson>) : BookClient {
    override fun fetchAll(): List<BookJson> = payload
}

class CatalogService(private val client: BookClient) {
    fun titlesForAuthor(author: String): List<String> {
        val needle = author.lowercase()
        return client.fetchAll().filter { it.author.lowercase() == needle }.map { it.title }
    }
}
