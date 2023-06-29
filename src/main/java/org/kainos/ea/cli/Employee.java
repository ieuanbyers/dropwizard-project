package org.kainos.ea.cli;

public class Employee {
    private int employeeID;
    private String name;
    private double salary;
    private String bankAccountNo;
    private String natInsuranceNo;

    public Employee(int employeeID, String name, double salary, String bankAccountNo, String natInsuranceNo) {
        setEmployeeID(employeeID);
        setName(name);
        setSalary(salary);
        setBankAccountNo(bankAccountNo);
        setNatInsuranceNo(natInsuranceNo);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getNatInsuranceNo() {
        return natInsuranceNo;
    }

    public void setNatInsuranceNo(String natInsuranceNo) {
        this.natInsuranceNo = natInsuranceNo;
    }
}
