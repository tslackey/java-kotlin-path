
package path.mid.library.loan

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.Instant

@Entity
class Loan(
    var bookId: Long,
    var memberId: Long,
    var checkedOutAt: Instant = Instant.now(),
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}
