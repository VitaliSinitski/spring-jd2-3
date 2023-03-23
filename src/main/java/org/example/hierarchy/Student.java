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
@DiscriminatorValue("S")
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "Student")
public class Student extends Person1 implements Serializable {
    @Column(name = "faculty_univer")
    private String faculty;
    @Column
    private Double mark;
}
