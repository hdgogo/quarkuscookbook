package org.example.app.restclinet;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.Set;

@Path("extensions")
@RegisterRestClient(configKey="extensions-api")
public interface ExtensionsService {


    @GET
    Set<Extension> getById(@QueryParam("id") String id);

    @GET
    @Path("/stream/{stream}")
    Set<Extension> getByStream(@PathParam("stream") String stream, @QueryParam("id") String id);


}
