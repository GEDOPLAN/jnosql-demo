package de.gedoplan.showcase.jnosql.rest;

import de.gedoplan.showcase.jnosql.model.Part;
import de.gedoplan.showcase.jnosql.service.PartService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@Path("part")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PartEndpoint {
    
    @Inject
    PartService partService;
    
    @GET
    @Path("{name}")
    public Part getPart(@PathParam("name") String name) {
        var result = partService.getPartByKey(name);
        if (result.isEmpty()) {
            throw new NotFoundException();
        }
        return result.get();
    }

}
