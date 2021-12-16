package de.gedoplan.showcase.jnosql.model;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Entity
public class Customer {
    
    @Id("id")
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private Address address;
    
}
