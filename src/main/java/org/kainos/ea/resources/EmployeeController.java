package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Dropwizard Project - Employee API")
@Path("/api")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/employees")
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

    @PUT
    @Path("/employees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") int id, EmployeeRequest employee){
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
}
