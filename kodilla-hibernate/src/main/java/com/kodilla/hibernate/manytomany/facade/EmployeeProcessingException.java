package com.kodilla.hibernate.manytomany.facade;

public class EmployeeProcessingException extends Exception {
    public static String ERR_NOT_FOUND_EMPLOYEE = "The employee was not found";
    public static String ERR_DELETE_DATA_AFTER_TEST = "Test data has not been deleted";

    public EmployeeProcessingException (String message){
        super(message);
    }
}
