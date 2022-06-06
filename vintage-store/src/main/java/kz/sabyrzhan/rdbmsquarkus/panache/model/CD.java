package kz.sabyrzhan.rdbmsquarkus.panache.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "t_cds")
public class CD extends Item {
    @Column
    private String musicCompany;

    @Column
    private String genre;

    @OneToMany(mappedBy = "cd")
    private List<Track> tracks;
}
