package org.example.ch7.persistence.panache;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    NewPersonRepository repository;

    @GET
    public List<Person> list(){
        return Person.listAll();
    }

    @GET
    @Path("/new")
    public List<NewPerson> newList(){
        return repository.findAlive();
    }

    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") Long id){
        return Person.findById(id);
    }

    @POST
    @Transactional
    public Response create(Person person){
        person.persist();
        return Response.created(URI.create("/persons/"+person.id)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Person update(@PathParam("id") Long id , Person person){
        Person entity = Person.findById(id);
        if(entity ==null){
            throw new NotFoundException();
        }

        entity.name = person.name;;
        return entity;
    }



    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id){
        Person entity = Person.findById(id);
        if(entity == null){
            throw new NotFoundException();
        }
        entity.delete();
    }


    @GET
    @Path("/search/{name}")
    public Person search(@PathParam("name") String name){
        return Person.findByName(name);
    }

    @GET
    @Path("/search/new/{name}")
    public NewPerson searchnew(@PathParam("name") String name){
        return repository.findByName(name);
    }


    @GET
    @Path("/count")
    public Long count(){
        return Person.count();
    }
}
