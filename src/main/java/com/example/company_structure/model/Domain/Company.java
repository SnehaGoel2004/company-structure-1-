

package com.example.company_structure.model.Domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="company") //allow the spring to refer to main company table(custom table)
public class Company {

    @Id
    //automatically generate the ID for the employee when the user creates an employee and also auto-increment it
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String name;
//"company" is the name of the field in the child (Department) table and any change in company will affect the dept.
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Department> departments;

    //  No-arg constructor
    public Company() {
    }

    //  All-arg constructor
    public Company(Long id, String name, List<Department> departments) {
        this.companyId = id;
        this.name = name;
        this.departments = departments;
    }

    //  Getters and Setters
    public Long getId() {
        return companyId;
    }
    @SuppressWarnings("unused")

    public void setId(Long id) {
        this.companyId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @SuppressWarnings("unused")

    public List<Department> getDepartments() {
        return departments;
    }
    @SuppressWarnings("unused")

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    // toString for logging/debugging
    @Override
    public String toString() {
        return "Company{" +
                "id=" + companyId +
                ", name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}

