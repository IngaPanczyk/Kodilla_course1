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
public class EmployeeFasade {
    @Autowired
    EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public void findEmployee(final String text) throws EmployeeProcessingException {

        LOGGER.info("Search phrase: " + text);

        List<Employee> employees = employeeDao.findEmployeeByText(text);

        if (employees.size() < 0) {
            LOGGER.error(CompanyProcessingException.ERR_NOT_FOUND_COMPANY);
            throw new EmployeeProcessingException(EmployeeProcessingException.ERR_NOT_FOUND_EMPLOYEE);
        } else {
            LOGGER.info("Found " + employees.size() + " employees with phrase: " + text);
        }
        try {
            employeeDao.deleteAll();
            LOGGER.info("Test data has been deleted");
        } catch (Exception e) {
            LOGGER.error(EmployeeProcessingException.ERR_DELETE_DATA_AFTER_TEST);
        }
    }
}
