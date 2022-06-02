package kz.sabyrzhan.rdbmsquarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import kz.sabyrzhan.rdbmsquarkus.jpa.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CustomerRepository implements PanacheRepository<Customer> {
}
