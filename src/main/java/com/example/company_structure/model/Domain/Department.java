package com.example.company_structure.model.Domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autogenerate the id by db
    private Long id;

    private String name; // TECH, FINANCE, etc.
//@column is used to customize the column.
    // Just storing the reference (foreign key) to the company to avoid storing the complete comapny object.
    @Column(name = "company_id", nullable = false)
    private Long companyId; //allow to access company by Department using companyId
 // a field name department exist in employee table, cascade means any operation u perform on dpartment will apply on employee too.
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department() {
    }

    public Department(Long id, String name, Long companyId, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
        this.employees = employees;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                ", employees=" + employees +
                '}';
    }


}
