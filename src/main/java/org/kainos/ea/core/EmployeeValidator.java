package org.kainos.ea.core;

import org.kainos.ea.cli.EmployeeRequest;

public class EmployeeValidator {

    public String isValidEmployee(EmployeeRequest employee) {

        if (employee.getName().length() > 50) {

            return "Name greater than 50 characters";

        }

        if (employee.getSalary() > 1000000000) {

            return "Nobody gets paid that much. Salary too big";

        }

        if (employee.getBankAccountNo().length() > 20) {

            return "Bank Account Number is greater than 20 characters";

        }

        if (employee.getNatInsuranceNo().length() > 9) {

            return "National Insurance Number is greater than 9 characters";

        }

        return null;

    }

}