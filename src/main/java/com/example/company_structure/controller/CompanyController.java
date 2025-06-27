package com.example.company_structure.controller;

import com.example.company_structure.model.Domain.Company;
import com.example.company_structure.service.CompanyService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/api/companies")

public class CompanyController {
    //creating logger
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company createCompany(@Valid @RequestBody Company company) {
        logger.info("Received request to create company: {}", company);
        return companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        logger.info("Fetching all companies");
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        logger.info("Fetching company with id: {}", id);
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        logger.info("Updating company with id: {}", id);
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        logger.info("Deleting company with id: {}", id);
        companyService.deleteCompany(id);
    }
}
