package com.example.company_structure.controller;
import com.example.company_structure.model.Domain.Department;

import com.example.company_structure.service.DepartmentService;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")

public class DepartmentController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/company/{companyId}")
    public Department createDepartment(@PathVariable Long companyId, @Valid @RequestBody Department department) {
        logger.info("Creating department {} for company ID {}", department.getName(), companyId);
        return departmentService.createDepartment(companyId, department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        logger.info("Fetching all departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        logger.info("Fetching department with ID {}", id);
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        logger.info("Updating department with ID {}", id);
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        logger.info("Deleting department with ID {}", id);
        departmentService.deleteDepartment(id);
    }
}
