package kz.sabyrzhan.rdbmsquarkus.panache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Book extends Item {
    @Column
    private String isbn;

    @Column
    private int numberOfPages;

    @Column
    private LocalDate publicationDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Language language;

    @JoinColumn(name = "publisher_id")
    @ManyToOne
    private Publisher publisher;
}
