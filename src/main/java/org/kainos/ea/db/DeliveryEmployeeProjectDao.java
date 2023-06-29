package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryEmployeeProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class DeliveryEmployeeProjectDao {

    public void removeEmployeeFromProject(int id, int projectID) throws SQLException {
        Connection c = getConnection();

        String updateStatement = "UPDATE DeliveryEmployeeProject SET EndDate = NOW() WHERE DeliveryEmployeeID = ?"
                +" WHERE ProjectID = ?;";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.executeUpdate();
    }
}
