package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployeeProject;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.core.DeliveryEmployeeProjectValidator;
import org.kainos.ea.core.EmployeeValidator;
import org.kainos.ea.db.DeliveryEmployeeProjectDao;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;

public class DeliveryEmployeeProjectService {

    private DeliveryEmployeeProjectDao deliveryEmployeeProjectDao = new DeliveryEmployeeProjectDao();
    private DeliveryEmployeeProjectValidator deliveryEmployeeProjectValidator = new DeliveryEmployeeProjectValidator();

    public void removeEmployeeFromDeliveryEmployeeProject(int id, DeliveryEmployeeProject project) throws InvalidEmployeeException {
        try{
            String validation = deliveryEmployeeProjectValidator.removeEmployeeFromProject(id, project);
            if (validation != null){
                throw new InvalidEmployeeException(validation);
            }

            deliveryEmployeeProjectDao.removeEmployeeFromProject(id, project.getProjectID());
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }



}
