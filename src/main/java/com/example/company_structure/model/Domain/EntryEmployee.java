package com.example.company_structure.model.Domain;
import com.example.company_structure.model.Enums.Level;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Optional;

@Entity
@DiscriminatorValue("ENTRY") //tells jpa to store the value "ENTRY" in employee-type column
public class EntryEmployee extends Employee {
@SuppressWarnings("")
    public EntryEmployee() {}

    public EntryEmployee(Long id, String name, double salary,Department department) {
        super(id, name, salary, Level.ENTRY, department);
    }



    @Override
    public double calculateSalary() {
        return salary + 0.05 * salary;
    }
}