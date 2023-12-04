package de.gedoplan.showcase.jnosql.repository;

import de.gedoplan.showcase.jnosql.model.Customer;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  public List<Customer> findByName(String name);

}
