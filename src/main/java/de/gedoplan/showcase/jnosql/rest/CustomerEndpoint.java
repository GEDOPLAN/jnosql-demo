package de.gedoplan.showcase.jnosql.rest;

import de.gedoplan.showcase.jnosql.model.Customer;
import de.gedoplan.showcase.jnosql.repository.CustomerRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerEndpoint {

    @Inject
    CustomerRepository customerRepository;

    @GET
    public List<Customer> findCustomer(@QueryParam("name") String name) {
        if (name != null) {
            return customerRepository.findByName(name);
        }
        return customerRepository.findAll().toList();
    }

    @GET
    @Path("{id}")
    public Customer findCustomer(@PathParam("id") Long id) {
        return customerRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    @POST
    public Response createCustomer(Customer customer, @Context UriInfo uriInfo) {
        var createdCustomer = customerRepository.save(customer);
        return Response.created(uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(createdCustomer.getId())).build())
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") Long id) {
        customerRepository.deleteById(id);
        return Response.noContent().build();
    }

}
