package org.kainos.ea.cli;

public class SalesEmployee extends Employee {

    public SalesEmployee(int employeeID, String name, double salary, String bankAccountNo, String natInsuranceNo, float commissionRate) {
        super(employeeID, name, salary, bankAccountNo, natInsuranceNo);
        this.commissionRate = commissionRate;
    }

    public float getCommissionRate() {return commissionRate;}

    public void setCommissionRate(float commissionRate) {this.commissionRate = commissionRate;}

    private float commissionRate;

}
