package de.gedoplan.showcase.jnosql.model;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Part {
    @Id
    String name;
    @Column
    Double price;
}
