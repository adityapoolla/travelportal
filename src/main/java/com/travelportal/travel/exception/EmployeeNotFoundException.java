package com.travelportal.travel.exception;

public class EmployeeNotFoundException extends RuntimeException {

    private final String message;
    public EmployeeNotFoundException(String message) {
        this.message = message;
    }
}
