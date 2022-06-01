package kz.sabyrzhan.rdbmsquarkus.jdbc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    public void createArtist_success() throws Exception {
        var artist = Artist.builder()
                .name("testName")
                .bio("test bio")
                .createdDate(Instant.now())
                .build();

        artistRepository.persist(artist);

        assertTrue(artist.getId() > 0);
        var expectedArtist = artistRepository.findById(artist.getId());
        assertNotNull(expectedArtist);
        assertEquals("testName", expectedArtist.getName());
        assertEquals("test bio", expectedArtist.getBio());
    }
}
