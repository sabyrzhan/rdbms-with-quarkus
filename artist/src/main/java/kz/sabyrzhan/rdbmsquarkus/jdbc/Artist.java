package kz.sabyrzhan.rdbmsquarkus.jdbc;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Artist {
    private long id;
    private String name;
    private String bio;
    private Instant createdDate = Instant.now();
}
