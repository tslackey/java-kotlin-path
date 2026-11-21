
package path.mid.library.loan;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loans;

    public LoanController(LoanService loans) {
        this.loans = loans;
    }

    @PostMapping
    public Loan checkout(@RequestBody CheckoutRequest request) {
        return loans.checkout(request.bookId(), request.memberId());
    }

    public record CheckoutRequest(long bookId, long memberId) {}
}
