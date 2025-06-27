package com.example.company_structure.repository;

import com.example.company_structure.model.Domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
