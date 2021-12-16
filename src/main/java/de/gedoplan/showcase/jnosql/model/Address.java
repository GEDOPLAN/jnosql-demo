package de.gedoplan.showcase.jnosql.model;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Embeddable;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Embeddable
public class Address {
    
    @Column
    private String street;
    @Column
    private String postcode;
    @Column
    private String country;
    
}
