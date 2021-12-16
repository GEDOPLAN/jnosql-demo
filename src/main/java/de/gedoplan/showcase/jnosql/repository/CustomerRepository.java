package de.gedoplan.showcase.jnosql.repository;

import de.gedoplan.showcase.jnosql.model.Customer;
import jakarta.nosql.mapping.Repository;
import java.util.List;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
public interface CustomerRepository extends Repository<Customer, Long> {
    
    public List<Customer> findAll();
    
}
