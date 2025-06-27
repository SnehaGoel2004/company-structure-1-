package com.example.company_structure.service;

import com.example.company_structure.model.Domain.Company;
import com.example.company_structure.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //enables the mockito
public class CompanyServiceTest {
    @Mock  //create the mock(fake version) of the dependency
    private CompanyRepository companyRepository;

    @InjectMocks  // inject the mock dependency in the object you r testing.
    private CompanyService companyService;

    @Test //declares a method as test data

    void testCreateCompany_WhenExists(){ //if exist
        Company sampleCompany=new Company(); // created a sample company with id and name.
        sampleCompany.setId(1L);
        sampleCompany.setName("Tata");

        when(companyRepository.save(sampleCompany)).thenReturn(sampleCompany);
        Company savedCompany=companyService.createCompany(sampleCompany);

        //Assertion to check if the value returned by the method matches with the expaected value or not.
        // if matches then test- pass otherwise fail.
        assertNotNull(savedCompany);
        assertEquals("Tata", savedCompany.getName());

        //verify the interaction with mocked dependency
        //times(1) ensures that the method save(savedcompny) os called once only.
        verify(companyRepository,times(1)).save(savedCompany);

    }


    @Test
    void testGetAllCompanies_WhenExists(){
        Company c1=new Company();
        c1.setId(1L);
        c1.setName("Wipro");
        Company c2=new Company();
        c2.setId(2L);
        c2.setName("Infosys");

        List<Company> company= List.of(c1,c2);
        when(companyRepository.findAll()).thenReturn(company);

        List<Company> result=companyService.getAllCompanies();
        //assertion
        assertNotNull(result);
        assertEquals(2L,result.get(0).getId());
        assertEquals("Infosys",result.getLast().getName());

        verify(companyRepository,times(1)).findAll();
    }

    @Test
    void testGetCompanyById_WhenExists() {
        Company company = new Company();
        company.setId(1L);
        company.setName("Wipro");

        when(companyRepository.findById(1L)).thenReturn(Optional.of(company));

        Company result = companyService.getCompanyById(1L);

        assertNotNull(result);
        assertEquals("Wipro", result.getName());
        verify(companyRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateCompany() {
        Company existingCompany = new Company();
        existingCompany.setId(1L);
        existingCompany.setName("Tata");

        Company updatedCompany = new Company();
        updatedCompany.setName("TCS");

        when(companyRepository.findById(1L)).thenReturn(Optional.of(existingCompany));
        Company result = companyService.updateCompany(1L, updatedCompany);

        //assertion
        assertNotNull(result);
        assertEquals("TCS", result.getName());
        verify(companyRepository,times(1)).findById(1L);
        verify(companyRepository,times(1)).save(existingCompany);
    }

    @Test
    void testDeleteCompany_WhenExists() {
        //check if the company with given id (1L) exists or not.
        when(companyRepository.existsById(1L)).thenReturn(true);

        Company deletedcompany=companyService.deleteCompany(1L);

        verify(companyRepository, times(1)).existsById(1L);
        verify(companyRepository, times(1)).deleteById(1L);
    }


}
