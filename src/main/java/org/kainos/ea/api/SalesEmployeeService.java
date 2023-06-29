package org.kainos.ea.api;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.*;
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

    public void updateSalesEmployee(int id, SalesEmployeeRequest employee) throws InvalidEmployeeException, FailedToUpdateEmployeeException, EmployeeDoesNotExistException {
        try{
            String validation = salesEmployeeValidator.isValidEmployee(employee);
            if (validation != null){
                throw new InvalidEmployeeException(validation);
            }

            SalesEmployee employeeToUpdate = salesEmployeeDao.getSalesEmployeeByID(id);

            if (employeeToUpdate == null){
                throw new EmployeeDoesNotExistException();
            }

            salesEmployeeDao.updateSalesEmployee(id, employee);
        } catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }

    public SalesEmployee getSalesEmployeeByID(int id) throws FailedToGetEmployeeException, EmployeeDoesNotExistException {

        try {
            SalesEmployee employee = salesEmployeeDao.getSalesEmployeeByID(id);

            if (employee == null) {
                throw new EmployeeDoesNotExistException();
            }
            return employee;
        } catch (SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToGetEmployeeException();
        }
    }
}
