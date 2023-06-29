package org.kainos.ea.client;

public class InvalidEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Employee is not valid in DB - failed to pass employeeValidator conditions";
    }
}
