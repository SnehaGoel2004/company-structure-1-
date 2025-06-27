
package com.example.company_structure.controller;
import com.example.company_structure.model.Domain.Employee;
import com.example.company_structure.service.EmployeeService;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.company_structure.model.dto.CreateEmployeeRequest;
import com.example.company_structure.model.dto.EmployeeResponse;

import java.util.List;


@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/department/{departmentId}")
    public EmployeeResponse createEmployee(@PathVariable Long departmentId, @Valid @RequestBody CreateEmployeeRequest request) {
        logger.info("Creating employee {} in department {}", request.getName(), request.getDepartmentId());
        return employeeService.createEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id) {
        logger.info("Fetching employee with ID {}", id);
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable Long id, @RequestBody CreateEmployeeRequest request) {
        logger.info("Updating employee with ID {}", id);
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        logger.info("Deleting employee with ID {}", id);
        employeeService.deleteEmployee(id);
    }
}

