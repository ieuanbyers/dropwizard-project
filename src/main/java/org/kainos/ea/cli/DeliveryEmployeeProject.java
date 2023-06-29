package org.kainos.ea.cli;

import java.sql.Date;

public class DeliveryEmployeeProject {
    private int DeliveryEmployeeID;
    private int ProjectID;
    private Date StartDate;

    public DeliveryEmployeeProject(int deliveryEmployeeID, int projectID, Date startDate, Date endDate) {
        setDeliveryEmployeeID(deliveryEmployeeID);
        setProjectID(projectID);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    private Date EndDate;

    public int getDeliveryEmployeeID() {
        return DeliveryEmployeeID;
    }

    public void setDeliveryEmployeeID(int deliveryEmployeeID) {
        DeliveryEmployeeID = deliveryEmployeeID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }





}
