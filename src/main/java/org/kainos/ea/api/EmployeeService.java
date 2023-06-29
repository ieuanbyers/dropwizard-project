package org.kainos.ea.api;

import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.core.EmployeeValidator;
import org.kainos.ea.db.EmployeeDao;
import java.sql.SQLException;


public class EmployeeService {

        private EmployeeDao employeeDao = new EmployeeDao();

        private EmployeeValidator employeeValidator = new EmployeeValidator();

    public int createEmployee (EmployeeRequest employee) throws FailedToCreateEmployeeException, InvalidEmployeeException {

        try {

            String validation = employeeValidator.isValidEmployee(employee);

            if(validation != null){
                throw new InvalidEmployeeException(validation);
            }

            int id = employeeDao.createDeliveryEmployee(employee);

            if(id < 1) {
                throw new FailedToCreateEmployeeException();
            }
            return id;
        }  catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateEmployeeException();
        }

    }




}
