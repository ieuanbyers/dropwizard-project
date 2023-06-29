package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import java.sql.*;
import static org.kainos.ea.db.DatabaseConnector.getConnection;
import org.kainos.ea.cli.EmployeeRequest;

import java.sql.*;

public class EmployeeDao {
    public int createDeliveryEmployee(EmployeeRequest employee) throws SQLException{
        Connection c = getConnection();

        String insertStatement = "INSERT INTO DeliveryEmployee(Name, Salary, BankAccountNo, NatInsuranceNo) VALUES (?, ?, ?, ?);";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

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


    public void updateDeliveryEmployee(int id, EmployeeRequest employee) throws SQLException{
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE DeliveryEmployee SET Name = ?, Salary = ?, BankAccountNo = ?, NatInsuranceNo = ? WHERE DeliveryEmployeeID = ?;";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNo());
        st.setString(4, employee.getNatInsuranceNo());
        st.setInt(5, id);

        st.executeUpdate();

    }

    public Employee getEmployeeByID(int id) throws SQLException {
        Connection c = getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT (`Name`,Salary,BankAccountNo,NatInsuranceNo) FROM `DeliveryEmployee`"
                + "WHERE DeliveryEmployeeID = "+id);


        while (rs.next()) {
            return new Employee(
                    rs.getInt("DeliveryEmployeeID"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNo"),
                    rs.getString("NatInsuranceNo")
            );

        }
        return null;
    }


}
