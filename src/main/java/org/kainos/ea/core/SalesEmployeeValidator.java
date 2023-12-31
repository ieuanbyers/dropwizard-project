package org.kainos.ea.core;

import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.core.EmployeeValidator;

public class SalesEmployeeValidator extends EmployeeValidator{

    public String isValidEmployee(SalesEmployeeRequest employee)  {

        if (employee.getCommissionRate() < 0.0f || employee.getCommissionRate() > 1.0f) {
            return "Commission rate entered is out of bounds";
        }
        return null;
    }
}
