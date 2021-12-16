package de.gedoplan.showcase.jnosql.service;

import de.gedoplan.showcase.jnosql.model.Customer;
import de.gedoplan.showcase.jnosql.repository.CustomerRepository;
import jakarta.nosql.mapping.Database;
import jakarta.nosql.mapping.DatabaseType;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@RequestScoped
public class CustomerService {

    @Inject
    @Database(DatabaseType.DOCUMENT)
    CustomerRepository customerRepository;
    
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
    
    public Customer savePerson(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public void deletePerson(Long id) {
        customerRepository.deleteById(id);
    }

}
