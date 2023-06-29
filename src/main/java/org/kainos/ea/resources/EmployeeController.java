package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.EmployeeRequest;

import org.kainos.ea.client.*;

import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Dropwizard Project - Delivery Employee API")
@Path("/api")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/deliveryemployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(EmployeeRequest employee) {
        try{
            return Response.status(Response.Status.CREATED).entity(employeeService.createEmployee(employee)).build();
        } catch (FailedToCreateEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().entity(e.getMessage()).build();
        } catch (InvalidEmployeeException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/deliveryemployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeByID(@PathParam("id") int id){

        try {
            return Response.ok(employeeService.getEmployeeByID(id)).build();
        } catch (FailedToGetEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (EmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();        }
    }

    @GET //accessed via http GET request
    @Path("/deliveryemployee") //URL ends with /products
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDeliveryEmployees() {
        try {
            return Response.ok(employeeService.getAllEmployees()).build();
        } catch (FailedToCreateEmployeeException e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/deliveryemployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateDeliveryEmployees(@PathParam("id") int id, EmployeeRequest employee){

        try{
            employeeService.updateDeliveryEmployee(id, employee);

            return Response.ok().build();
        } catch (FailedToUpdateEmployeeException e){
            System.err.println(e.getMessage());

            return Response.serverError().entity(e.getMessage()).build();
        } catch (InvalidEmployeeException | EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @DELETE
    @Path("/deliveryemployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("id") int id){
        try{
            employeeService.deleteEmployee(id);

            return Response.ok().build();
        } catch (EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToDeleteEmployeeException e){
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

}
