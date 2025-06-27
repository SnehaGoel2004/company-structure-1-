package com.example.company_structure.model.Domain;

import com.example.company_structure.model.Enums.Level;
import jakarta.persistence.*;

@Entity
@Table(name="employee") // allow spring to refer to main (parent) employee table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //tells jpa to store all subclasses of employee or parent class in a single table.

// Discriminator will tell the jpa to instantiate the subclass on the basis of the value of the employee-type.
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    protected double salary;

// to map the enum to db.
    @Enumerated(EnumType.STRING)
    protected Level level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    protected Department department;

    public Employee() {}

    public Employee(Long id, String name, double salary, Level level, Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.level = level;
        this.department = department;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Level getLevel() { return level; }
    public void setLevel(Level level) { this.level = level; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    // Abstract salary calculation logic
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseSalary=" + salary +
                ", level=" + level +
                ", department=" + (department != null ? department.getId() : null) +
                ", finalSalary=" + calculateSalary() +
                '}';
    }
}








