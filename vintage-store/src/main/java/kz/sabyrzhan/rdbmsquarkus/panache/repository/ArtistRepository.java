package kz.sabyrzhan.rdbmsquarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import kz.sabyrzhan.rdbmsquarkus.jdbc.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ArtistRepository implements PanacheRepository<Artist> {
}
