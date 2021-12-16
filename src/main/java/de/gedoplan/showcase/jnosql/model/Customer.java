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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", street=" + street + ", postcode=" + postcode + ", city=" + city + '}';
    }

}
