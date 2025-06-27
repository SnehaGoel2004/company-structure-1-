package com.example.company_structure.model.Domain;
import com.example.company_structure.model.Enums.Level;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Optional;

@Entity
@DiscriminatorValue("MANAGER") // tells jpa to store "MANAGER" in the employee_type.
public class ManagerEmployee extends Employee {

    public ManagerEmployee() {}

    public ManagerEmployee(Long id, String name, double salary, Department department) {
        super(id, name, salary, Level.MANAGER, department);
    }


    @Override
    public double calculateSalary() {
        return salary + 0.20 * salary + 5000;
    }
}