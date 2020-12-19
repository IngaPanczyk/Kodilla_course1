package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyFacade {
    @Autowired
    CompanyDao companyDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public void findCompany(final String text) throws CompanyProcessingException {

        LOGGER.info("Search phrase: " + text);

        List<Company> companies = companyDao.findCompanyByText(text);

        if (companies.size() < 0) {
            LOGGER.error(CompanyProcessingException.ERR_NOT_FOUND_COMPANY);
            throw new CompanyProcessingException(CompanyProcessingException.ERR_NOT_FOUND_COMPANY);
        } else {
            LOGGER.info("Found " + companies.size() + " companies with phrase: " + text);
        }
        try {
            companyDao.deleteAll();
            LOGGER.info("Test data has been deleted");
        }catch (Exception e){
            LOGGER.error(CompanyProcessingException.ERR_DELETE_DATA_AFTER_TEST);
        }
    }
}
