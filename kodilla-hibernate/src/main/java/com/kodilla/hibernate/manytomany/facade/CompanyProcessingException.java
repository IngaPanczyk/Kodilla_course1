package com.kodilla.hibernate.manytomany.facade;

public class CompanyProcessingException extends Exception {
    public static String ERR_NOT_FOUND_COMPANY = "The company was not found";
    public static String ERR_DELETE_DATA_AFTER_TEST = "Test data has not been deleted";

    public CompanyProcessingException (String message){
        super(message);
    }
}
