
package path.mid.library.loan

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import path.mid.library.book.BookRepository
import path.mid.library.member.MemberRepository

@Service
class LoanService(
    private val books: BookRepository,
    private val members: MemberRepository,
    private val loans: LoanRepository,
) {
    @Transactional
    fun checkout(bookId: Long, memberId: Long): Loan {
        val book = books.findById(bookId).orElseThrow { IllegalArgumentException("unknown book") }
        members.findById(memberId).orElseThrow { IllegalArgumentException("unknown member") }
        check(book.isAvailable) { "book already checked out" }
        book.isAvailable = false
        books.save(book)
        return loans.save(Loan(bookId, memberId))
    }
}
