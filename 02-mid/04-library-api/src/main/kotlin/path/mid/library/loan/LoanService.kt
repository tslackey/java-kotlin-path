
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
        TODO("Implement checkout: existing available book, existing member, then persist a loan")
    }
}
