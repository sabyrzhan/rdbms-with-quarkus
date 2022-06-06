package kz.sabyrzhan.rdbmsquarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import kz.sabyrzhan.rdbmsquarkus.jpa.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

import static io.quarkus.panache.common.Sort.Direction.Descending;

@ApplicationScoped
@Transactional
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> findAllByFirstName(String firstName) {
        return list("firstName = :fName", Sort.by("firstName", Descending), Parameters.with("fName", firstName));
    }
}
