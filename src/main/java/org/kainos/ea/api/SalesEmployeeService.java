package org.kainos.ea.api;

import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.SalesEmployeeDao;

import java.sql.SQLException;

public class SalesEmployeeService {

    SalesEmployeeDao salesEmployeeDao = new SalesEmployeeDao();

    SalesEmployeeValidator salesEmployeeValidator = new SalesEmployeeValidator();

    public int createSalesEmployee (SalesEmployeeRequest employee) throws FailedToCreateEmployeeException, InvalidEmployeeException {

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
}
