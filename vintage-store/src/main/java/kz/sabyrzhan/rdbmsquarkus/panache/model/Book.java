package kz.sabyrzhan.rdbmsquarkus.panache.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "t_books")
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
