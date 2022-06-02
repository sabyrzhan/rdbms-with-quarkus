package kz.sabyrzhan.rdbmsquarkus.panache;

import io.quarkus.test.junit.QuarkusTest;
import kz.sabyrzhan.rdbmsquarkus.jpa.Customer;
import kz.sabyrzhan.rdbmsquarkus.panache.repository.CustomerRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.Instant;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomerRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    void saveCustomer_success() {
        var customer = Customer.builder()
                .firstName("TestName")
                .lastName("TestLastname")
                .email("test@test.com")
                .createdDate(Instant.now())
                .build();

        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        var expected = customerRepository.findById(customer.getId());
        assertEquals("TestName", expected.getFirstName());
        assertEquals("TestLastname", expected.getLastName());
        assertEquals("test@test.com", expected.getEmail());
        assertTrue(customer.getCreatedDate().with(ChronoField.NANO_OF_SECOND, 0).equals(expected.getCreatedDate().with(ChronoField.NANO_OF_SECOND, 0)));
    }

}