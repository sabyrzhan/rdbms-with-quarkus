package kz.sabyrzhan.rdbmsquarkus.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class CustomerRepository {
    @Inject
    EntityManager em;

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    public Customer findById(long id) {
        return em.find(Customer.class, id);
    }
}
