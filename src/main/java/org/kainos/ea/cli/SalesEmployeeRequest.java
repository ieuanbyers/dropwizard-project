package org.kainos.ea.cli;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kainos.ea.cli.EmployeeRequest;

public class SalesEmployeeRequest extends EmployeeRequest{
    public SalesEmployeeRequest(String name, double salary, String bankAccountNo, String natInsuranceNo, @JsonProperty float commissionRate) {
        super(name, salary, bankAccountNo, natInsuranceNo);
        setCommissionRate(commissionRate);
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    private float commissionRate;
}