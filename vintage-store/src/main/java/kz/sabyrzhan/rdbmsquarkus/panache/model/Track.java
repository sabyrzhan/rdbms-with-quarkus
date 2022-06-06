package kz.sabyrzhan.rdbmsquarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "t_tracks")
@Data
public class Track extends PanacheEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Duration duration;

    @Column(nullable = false)
    private Instant createdDate = Instant.now();

    @ManyToOne
    @JoinColumn(name = "cd_id")
    private CD cd;
}
