package org.example.app.restclinet;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/extension")
public class ExtensionsResource {

    @RestClient
    FruitsService fruitsService;

    @RestClient
    ExtensionsService extensionsService;


    @GET
    @Blocking
    public Set<Fruit> list() {
        return fruitsService.list();
    }


    @GET
    @Path("/id/{id}")
    @Blocking
    public Set<Extension> id(String id) {
        return extensionsService.getById(id);
    }
}