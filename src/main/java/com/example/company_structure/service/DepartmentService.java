package com.example.company_structure.service;

import com.example.company_structure.exception.ResourceNotFoundException;
import com.example.company_structure.model.Domain.Company;
import com.example.company_structure.model.Domain.Department;
import com.example.company_structure.repository.CompanyRepository;
import com.example.company_structure.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;

    // Constructor injection
    public DepartmentService(DepartmentRepository departmentRepository,
                             CompanyRepository companyRepository) {
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
    }

    public Department createDepartment(Long companyId, Department department) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + companyId));
        department.setCompanyId(companyId);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + id));
    }

    public Department updateDepartment(Long id, Department updatedDept) {
        Department department = getDepartmentById(id);
        department.setName(updatedDept.getName());
        return departmentRepository.save(department); //
    }

    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with ID: " + id);
        }
        departmentRepository.deleteById(id);
    }
}
