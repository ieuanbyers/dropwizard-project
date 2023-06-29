package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import java.sql.*;
import static org.kainos.ea.db.DatabaseConnector.getConnection;
import org.kainos.ea.cli.EmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public int createDeliveryEmployee(EmployeeRequest employee) throws SQLException{
        Connection c = getConnection();

        String insertStatement = "INSERT INTO DeliveryEmployee(Name, Salary, BankAccountNo, NatInsuranceNo) VALUES (?, ?, ?, ?);";

        PreparedStatement st = c.prepareStatement(insertStatement);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNo());
        st.setString(4, employee.getNatInsuranceNo());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public EmployeeRequest getEmployeeByID(int id) throws SQLException {
        Connection c = getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT (`Name`,Salary,BankAccountNo,NatInsuranceNo) FROM `DeliveryEmployee`"
                + "WHERE DeliveryEmployeeID = "+id);


        while (rs.next()) {
            return new EmployeeRequest(
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNo"),
                    rs.getString("NatInsuranceNo")
            );

        }
        return null;
    }


    public List<EmployeeRequest> getAllEmployees() throws SQLException {
        Connection c = getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT (Name,Salary,BankAccountNo,NatInsuranceNo) FROM DeliveryEmployee;");

        List<EmployeeRequest> employeeList = new ArrayList<>();

        while (rs.next()) {
            EmployeeRequest employee = new EmployeeRequest(
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNo"),
                    rs.getString("NatInsuranceNo")
            );

            employeeList.add(employee);
        }
        return employeeList;
    }


}
