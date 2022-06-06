package kz.sabyrzhan.rdbmsquarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import kz.sabyrzhan.rdbmsquarkus.jdbc.Artist;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Item extends PanacheEntityBuilderEnabler {
    @Column
    private String title;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private Instant createdDate = Instant.now();

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
