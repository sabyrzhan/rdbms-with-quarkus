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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "t_items")
public class Item extends PanacheEntityBuilderEnabler {
    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private Instant createdDate = Instant.now();

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
