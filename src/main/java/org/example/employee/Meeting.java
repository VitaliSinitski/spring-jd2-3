package org.example.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@ToString(exclude = "employees")
public class Meeting extends DataEntity implements Serializable {


    @Column(name = "first_name")
    private String firstName;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<>();


}
