package kz.sabyrzhan.rdbmsquarkus.panache.repository;

import kz.sabyrzhan.rdbmsquarkus.panache.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PublisherRepository {
    @Transactional
    public void persist(Publisher publisher) {
        publisher.persist();
    }

    public Publisher findById(long id) {
        return Publisher.findById(id);
    }
}
