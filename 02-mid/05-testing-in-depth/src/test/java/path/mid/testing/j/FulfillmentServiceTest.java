
package path.mid.testing.j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FulfillmentServiceTest {

    @Mock
    Warehouse warehouse;

    @InjectMocks
    FulfillmentService service;

    @Test
    void reservesWhenInStock() {
        when(warehouse.available("sku")).thenReturn(5);
        assertThat(service.placeOrder("sku", 2)).isTrue();
        verify(warehouse).reserve("sku", 2);
    }

    @Test
    void doesNotReserveWhenShort() {
        when(warehouse.available("sku")).thenReturn(1);
        assertThat(service.placeOrder("sku", 2)).isFalse();
        verify(warehouse, never()).reserve("sku", 2);
    }
}
