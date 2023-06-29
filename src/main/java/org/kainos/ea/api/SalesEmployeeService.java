package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.SalesEmployeeDao;

import java.sql.SQLException;

public class SalesEmployeeService {

    SalesEmployeeDao salesEmployeeDao = new SalesEmployeeDao();

    SalesEmployeeValidator salesEmployeeValidator = new SalesEmployeeValidator();

    public int createSalesEmployee (SalesEmployeeRequest employee) throws FailedToCreateEmployeeException, InvalidEmployeeException, EmployeeDoesNotExistException {

        try {

            String validation = salesEmployeeValidator.isValidEmployee(employee);

            if (validation != null) {
                throw new InvalidEmployeeException(validation);
            }

//            Employee employeeToUpdate = salesEmployeeDao.getEmployeeById(id);
//
//            if (employeeToUpdate == null){
//                throw new EmployeeDoesNotExistException();
//            }

            int id = salesEmployeeDao.createSalesEmployee(employee);

            if (id < 1) {
                throw new FailedToCreateEmployeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateEmployeeException();
        }
    }

    public void updateSalesEmployee(int id, SalesEmployeeRequest employee) throws InvalidEmployeeException, FailedToUpdateEmployeeException {
        try{
            String validation = salesEmployeeValidator.isValidEmployee(employee);
            if (validation != null){
                throw new InvalidEmployeeException(validation);
            }

            salesEmployeeDao.updateSalesEmployee(id, employee);
        } catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }
}
