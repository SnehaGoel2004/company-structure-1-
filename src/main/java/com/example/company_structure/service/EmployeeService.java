package com.example.company_structure.service;
import com.example.company_structure.model.Domain.*;
import com.example.company_structure.exception.ResourceNotFoundException;
import com.example.company_structure.repository.DepartmentRepository;
import com.example.company_structure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.company_structure.model.dto.CreateEmployeeRequest;
import com.example.company_structure.model.dto.EmployeeResponse;
import com.example.company_structure.model.Enums.Level;

import java.util.List;



@Service
public class EmployeeService {
//field injection
    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final DepartmentRepository departmentRepository;

    //constructor injection
    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + request.getDepartmentId()));
        Employee actualEmployee = createEmployeeByLevel(request,department);


     // converting actualEmployee(entity) to DTO before saving.
        Employee savedEmployee= employeeRepository.save(actualEmployee);
        //now save DTO .
        return convertToResponse(savedEmployee);

    }
// fetches the employee record or list from db and convert it to DTO , convert each employee in the list to EmployeeResponse DTO and reutrn a DTO list.
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream()//convert the list to stream to apply operations
                .map(this::convertToResponse) // for each employee, convert to dto.
                .toList(); // return list
    }



    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
     return convertToResponse(employee);}




    public EmployeeResponse updateEmployee(Long id, CreateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("employee with this id not exist"+id));
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());

        //converts the level received from request suppose " entry" into uppercse "ENTRY" that is into corresponding enum constant from the level enum.
        employee.setLevel(Level.valueOf(request.getLevel().toUpperCase()));


        employee.setDepartment(departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(()-> new ResourceNotFoundException(" department with the id doesnot exist")));



        Employee employee1= employeeRepository.save(employee);
        return convertToResponse(employee1);
    }



    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

    private Employee createEmployeeByLevel(CreateEmployeeRequest input, Department department) {
        switch (Level.valueOf(input.getLevel())) {
            case ENTRY -> {
                return new EntryEmployee(null, input.getName(), input.getSalary(), department);
            }
            case MANAGER -> {
                return new ManagerEmployee(null, input.getName(), input.getSalary(), department);
            }
            case SENIOR -> {
                return new SeniorEmployee(null, input.getName(), input.getSalary(), department);
            }
            default -> throw new IllegalArgumentException("Invalid level: " + input.getLevel());
        }
    }
         // converting Entity class Employee to EmployeeDTO
        private EmployeeResponse convertToResponse(Employee employee) {
            return new EmployeeResponse(
                    employee.getId(),
                    employee.getName(),
                    employee.getSalary(),
                    employee.getLevel().name(),
                    employee.getDepartment().getId()
            );
        }
    }


