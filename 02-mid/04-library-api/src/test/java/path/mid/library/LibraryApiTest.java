
package path.mid.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LibraryApiTest {

    @Autowired
    TestRestTemplate http;

    @Test
    void createAndListBooks() {
        ResponseEntity<Map> created = http.postForEntity("/api/books", Map.of(
                "isbn", "978-1",
                "title", "Effective Java",
                "author", "Bloch"
        ), Map.class);
        assertThat(created.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(created.getBody()).containsEntry("title", "Effective Java");
        assertThat(http.getForEntity("/api/books", String.class).getBody()).contains("Effective Java");
    }

    @Test
    void checkoutThenRejectSecondLoan() {
        Map book = http.postForEntity("/api/books", Map.of(
                "isbn", "978-loan",
                "title", "Kotlin in Action",
                "author", "Jemerov"
        ), Map.class).getBody();
        Map member = http.postForEntity("/api/members", Map.of("name", "Ada"), Map.class).getBody();
        Number bookId = (Number) book.get("id");
        Number memberId = (Number) member.get("id");

        ResponseEntity<Map> loan = http.postForEntity("/api/loans", Map.of(
                "bookId", bookId,
                "memberId", memberId
        ), Map.class);
        assertThat(loan.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(loan.getBody()).containsKey("id");

        ResponseEntity<String> second = http.postForEntity("/api/loans", Map.of(
                "bookId", bookId,
                "memberId", memberId
        ), String.class);
        assertThat(second.getStatusCode().is2xxSuccessful()).isFalse();
    }
}
