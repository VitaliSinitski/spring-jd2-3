package org.example.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("E")
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "Employee1")
public class Employee1 extends Person1 implements Serializable {

    @Column
    private String company;
    @Column
    private Double salary;
}
