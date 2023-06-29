package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryEmployeeProjectService;
import org.kainos.ea.cli.DeliveryEmployeeProject;
import org.kainos.ea.client.InvalidEmployeeException;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Api("Dropwizard Project - Employee API")
@Path("/api")
public class DeliveryEmployeeProjectController {
    private DeliveryEmployeeProjectService deliveryEmployeeProjectService = new DeliveryEmployeeProjectService();

    @PUT
    @Path("/projects/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployeeProject(@PathParam("id") int id, DeliveryEmployeeProject project){
        try{
            deliveryEmployeeProjectService.removeEmployeeFromDeliveryEmployeeProject(id, project);

            return Response.ok().build();
        } catch (InvalidEmployeeException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
