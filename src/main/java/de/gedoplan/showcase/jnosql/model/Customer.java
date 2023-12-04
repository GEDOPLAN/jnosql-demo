package de.gedoplan.showcase.jnosql.model;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Getter
@Setter
@Entity("customer")
public class Customer {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String street;
    @Column
    private String postcode;
    @Column
    private String city;
}
