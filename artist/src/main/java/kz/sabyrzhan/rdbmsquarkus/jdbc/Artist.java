package kz.sabyrzhan.rdbmsquarkus.jdbc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    private long id;
    private String name;
    private String bio;
    private Instant createdDate = Instant.now();
}
