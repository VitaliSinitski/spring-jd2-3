package org.example.people;

import lombok.*;
import org.example.Person;
import org.example.employee.Employee;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(exclude = {"name", "age"})
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "people_id")
    private Integer peopleId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_id")
    private Home home;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "people_car",
    joinColumns = {@JoinColumn(name = "people_id")},
    inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private Set<Car> cars = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(peopleId, people.peopleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleId);
    }
}