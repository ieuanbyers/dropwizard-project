package org.kainos.ea.cli;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kainos.ea.cli.EmployeeRequest;

public class SalesEmployeeRequest extends EmployeeRequest{
    @JsonCreator
    public SalesEmployeeRequest(@JsonProperty("name") String name, @JsonProperty("salary") double salary, @JsonProperty("bankAccountNo") String bankAccountNo, @JsonProperty("natInsuranceNo") String natInsuranceNo, @JsonProperty("commissionRate") float commissionRate) {
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