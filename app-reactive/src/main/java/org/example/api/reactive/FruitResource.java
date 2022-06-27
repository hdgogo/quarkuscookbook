package org.example.api.reactive;


import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@ApplicationScoped
@Path("/fruits")
public class FruitResource {

    @Inject
    MyFriutBaseRepository repository;

    @GET
    public Uni<List<Fruit>> get() {
        return Fruit.listAll(Sort.by("name"));
    }

    @GET
    @Path("/{id}")
    public Uni<Fruit> getSingle(Long id) {
        return Fruit.findById(id);
    }

    @GET
    @Path("myfruits")
    public  Uni<List<MyFruit>> getMyfruit() {
        return repository.listAll(Sort.by("name"));
    }

    @GET
    @Path("myfruits/{id}")
    public Uni<MyFruit> getSingleMy(Long id) {
        return repository.findById(id);
    }
}
