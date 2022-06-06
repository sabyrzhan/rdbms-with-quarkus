package kz.sabyrzhan.rdbmsquarkus.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import kz.sabyrzhan.rdbmsquarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;
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
        expected = Publisher.findByName("TestName").orElseThrow(EntityNotFoundException::new);
        assertNotNull(expected);
        assertEquals("TestName", expected.name);
        assertEquals(1, Publisher.findNameLike("TestName").size());
    }
}
