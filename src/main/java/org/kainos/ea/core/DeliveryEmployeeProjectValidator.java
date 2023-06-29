package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployeeProject;
import org.kainos.ea.cli.SalesEmployeeRequest;

public class DeliveryEmployeeProjectValidator {

    public String removeEmployeeFromProject(int id, DeliveryEmployeeProject project)  {

        if (project.getProjectID() <= 0 || project == null) {
            return "Invalid Project ID";
        }

        if (id <= 0) {
            return "Invalid ID";
        }

        return null;
    }


}
