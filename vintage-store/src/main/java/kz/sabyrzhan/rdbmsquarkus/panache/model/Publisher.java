package kz.sabyrzhan.rdbmsquarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "t_publishers")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Publisher extends PanacheEntity {
    public String name;
    public Instant createdDate = Instant.now();

    public static Optional<Publisher> findByName(String name) {
        return find("name", name).firstResultOptional();
    }

    public static List<Publisher> findNameLike(String name) {
        return list("name like :name", Parameters.with("name", "%" + name + "%"));
    }
}
