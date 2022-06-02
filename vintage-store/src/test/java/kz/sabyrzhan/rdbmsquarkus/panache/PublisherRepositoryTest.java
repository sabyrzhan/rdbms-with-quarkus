package kz.sabyrzhan.rdbmsquarkus.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import kz.sabyrzhan.rdbmsquarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PublisherRepositoryTest {
    @Test
    @TestTransaction
    void persist_success() {
        var publisher = Publisher.builder()
                .name("TestName")
                .createdDate(Instant.now())
                .build();
        publisher.persist();
        assertNotNull(publisher.id);

        var expected = Publisher.<Publisher>findById(publisher.id);
        assertNotNull(expected);
        assertEquals("TestName", expected.name);
    }
}
