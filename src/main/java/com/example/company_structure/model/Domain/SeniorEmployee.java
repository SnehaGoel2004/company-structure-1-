package com.example.company_structure.model.Domain;
import com.example.company_structure.model.Enums.Level;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Optional;

@Entity
@DiscriminatorValue("SENIOR")
public class SeniorEmployee extends Employee {

    public SeniorEmployee() {}

    public SeniorEmployee(Long id, String name, double salary, Department department) {
        super(id, name, salary, Level.SENIOR, department);
    }

   // public SeniorEmployee(Long id, String name, double salary, Optional<Department> department) {
    //}

    @Override
    public double calculateSalary() {
        return salary + 0.30 * salary + 0.10 * salary;
    }
}
