package com.example.company_structure.repository;
import com.example.company_structure.model.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
