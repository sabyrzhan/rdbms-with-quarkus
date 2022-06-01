package kz.sabyrzhan.rdbmsquarkus.panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "publishers")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Publisher extends PanacheEntity {
    public String name;
    public Instant createdDate = Instant.now();
}
