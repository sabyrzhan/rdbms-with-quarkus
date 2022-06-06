package kz.sabyrzhan.rdbmsquarkus.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import kz.sabyrzhan.rdbmsquarkus.jdbc.Artist;
import kz.sabyrzhan.rdbmsquarkus.jpa.Customer;
import kz.sabyrzhan.rdbmsquarkus.panache.model.*;
import kz.sabyrzhan.rdbmsquarkus.panache.repository.CustomerRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PurchaseOrderRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    void purchaseOrder_success() {
        // Create an artist
        var artist = Artist.builder()
                .name("Artist Name")
                .bio("Artist bio")
                .build();

        // Create publisher
        var publisher = Publisher.builder()
                .name("Publisher name")
                .build();

        // Create a book
        var book = Book.builder()
                .title("Book title")
                .isbn("bookISBN")
                .numberOfPages(400)
                .language(Language.KAZAKH)
                .price(new BigDecimal("500"))
                .artist(artist)
                .publisher(publisher)
                .build();

        Book.persist(book);
        assertNotNull(book.id);

        // Create customer
        var customer = Customer.builder()
                .lastName("Firstname")
                .lastName("Lastname")
                .email("email@email.com")
                .build();
        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        // Create order line
        var orderLine = OrderLine.builder()
                .item(book)
                .quantity(1)
                .build();

        // Create purchase order
        var purchaseOrder = new PurchaseOrder().toBuilder()
                .customer(customer)
                .build()
                .withOrderLine(orderLine);
        PurchaseOrder.persist(purchaseOrder);
        assertNotNull(purchaseOrder.id);

        // Query purchase order
        var dbPurchaseOrder = PurchaseOrder.<PurchaseOrder>findById(purchaseOrder.id);
        assertNotNull(dbPurchaseOrder);
        assertEquals(1, dbPurchaseOrder.getOrders().size());
        var dbOrderLine = dbPurchaseOrder.getOrders().get(0);
        assertEquals(book.id, dbOrderLine.getItem().id);
        assertEquals(1, dbOrderLine.getQuantity());
    }
}
