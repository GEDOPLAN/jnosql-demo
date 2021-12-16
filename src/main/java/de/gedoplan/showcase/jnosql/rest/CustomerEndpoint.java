package de.gedoplan.showcase.jnosql.rest;

import de.gedoplan.showcase.jnosql.model.Customer;
import de.gedoplan.showcase.jnosql.service.CustomerService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerEndpoint {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    @GET
    @Path("{id}")
    public Customer findCustomer(@PathParam("id") Long id) {
        return customerService.findById(id).orElseThrow(NotFoundException::new);
    }

    @POST
    public Response createCustomer(Customer customer, @Context UriInfo uriInfo) {
        var createdCustomer = customerService.save(customer).orElseThrow(WebApplicationException::new);
        System.out.println("Customer: " + createdCustomer);
        return Response.created(uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(createdCustomer.getId())).build())
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") Long id) {
        customerService.delete(id);
        return Response.noContent().build();
    }

}
