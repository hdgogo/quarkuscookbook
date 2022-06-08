package org.example.app.restclinet;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("fruits")
@RegisterRestClient
public interface FruitsService {

    @GET
    Set<Fruit> list();
}
