package org.example.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/*
@Inheritance(strategy = InheritanceType.JOINED)
*/
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE",
discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
@Entity
@Table(name = "Person1")
public class Person1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;
    @AttributeOverrides({
            @AttributeOverride(name = "street",
            column = @Column(name = "home_street")),
            @AttributeOverride(name = "city",
            column = @Column(name = "home_city"))
    })
    @Embedded
    private Address homeAddress;
    @Embedded
    private Address address;

}
