package org.example.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table
public class Department extends DataEntity implements Serializable {
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }


    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
