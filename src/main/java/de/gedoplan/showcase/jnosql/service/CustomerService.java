package de.gedoplan.showcase.jnosql.service;

import de.gedoplan.showcase.jnosql.model.Customer;
import de.gedoplan.showcase.jnosql.repository.CustomerRepository;
import de.gedoplan.showcase.jnosql.DocumentCollectionManagerProducer;
import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.mapping.Database;
import jakarta.nosql.mapping.DatabaseType;
import jakarta.nosql.mapping.document.DocumentTemplate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@JBossLog
@RequestScoped
public class CustomerService {

    @Inject
    @Database(value = DatabaseType.DOCUMENT, provider = DocumentCollectionManagerProducer.CUSTOMER_COLLECTION)
    CustomerRepository customerRepository;

    @Inject
    @Database(value = DatabaseType.DOCUMENT, provider = DocumentCollectionManagerProducer.CUSTOMER_COLLECTION)
    private DocumentTemplate template;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findByName(String name) {
        log.info("Search customer with name: " + name);
        var query = DocumentQuery.select().from("Person").where("name").like(name).build();
        var result = template.select(query);
        return result.map(entry -> ((Customer) entry)).collect(Collectors.toList());
    }

    public Optional<Customer> save(Customer customer) {
        try {
            return Optional.of(customerRepository.save(customer));
        } catch (NullPointerException ex) {
            return Optional.empty();
        }
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}
