package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class DeliveryEmployeeProjectRequest {
    private int DeliveryEmployeeID;
    private int ProjectID;
    private Date StartDate;
    private Date EndDate;

    @JsonCreator
    public DeliveryEmployeeProjectRequest(@JsonProperty("projectID") int projectID, @JsonProperty("startDate") Date startDate,@JsonProperty("endDate") Date endDate) {
        setProjectID(projectID);
        setStartDate(startDate);
        setEndDate(endDate);
    }

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
