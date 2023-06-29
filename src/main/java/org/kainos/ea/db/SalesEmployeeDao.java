package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;

import java.sql.*;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class SalesEmployeeDao {
    public int createSalesEmployee(SalesEmployeeRequest employee) throws SQLException {
        Connection c = getConnection();

        String insertStatement = "INSERT INTO SalesEmployee(Name, Salary, BankAccountNo, NatInsuranceNo, CommissionRate) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNo());
        st.setString(4, employee.getNatInsuranceNo());
        st.setFloat(5, employee.getCommissionRate());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateSalesEmployee(int id, SalesEmployeeRequest employee) throws SQLException{
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE SalesEmployee SET Name = ?, Salary = ?, BankAccountNo = ?, NatInsuranceNo = ?, CommissionRate = ? WHERE SalesEmployeeID = ?;";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNo());
        st.setString(4, employee.getNatInsuranceNo());
        st.setFloat(5, employee.getCommissionRate());
        st.setInt(6, id);

        st.executeUpdate();

    }

    public SalesEmployee getSalesEmployeeByID(int id) throws SQLException {
        Connection c = getConnection();
        Statement st = c.createStatement();

       String selectStatement = "SELECT SalesEmployeeID, Name, Salary, BankAccountNo, NatInsuranceNo, CommissionRate FROM SalesEmployee WHERE SalesEmployeeID = " + id;

       ResultSet rs = st.executeQuery(selectStatement);


        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("SalesEmployeeID"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNo"),
                    rs.getString("NatInsuranceNo"),
                    rs.getFloat("CommissionRate")
            );

        }
        return null;
    }
}
