package com.example.company_structure.repository;

import com.example.company_structure.model.Domain.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
