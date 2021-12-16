package de.gedoplan.showcase.jnosql.repository;

import de.gedoplan.showcase.jnosql.model.Customer;
import jakarta.nosql.mapping.Repository;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
public interface CustomerRepository extends Repository<Customer, Long> {
    
}
