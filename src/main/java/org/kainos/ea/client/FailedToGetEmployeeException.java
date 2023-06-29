package org.kainos.ea.client;

public class FailedToGetEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to select/GET employee from DB";
    }
}
