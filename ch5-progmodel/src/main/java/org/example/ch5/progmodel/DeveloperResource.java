package org.example.ch5.progmodel;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/developer")
public class DeveloperResource {

    private static final List<Developer> developers = new ArrayList<>();

    @Inject
    Validator validator; //以Bean Validation 规范注入Validator类


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDeveloper(@Valid  Developer developer){ // @Valid 是校验对象的强制参数
        developers.add(developer);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getDevelopers(){
        return developers;
    }


    @POST
    @Path("/programmaticvalidation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProgrammaticValidation(Developer developer){
        Set<ConstraintViolation<Developer>> violations = validator.validate(developer);  //使用编程的方式校验对象

        if (violations.isEmpty()){ //如果没有错误
            developers.add(developer);
            return Response.ok().build();
        }else{  //如果有错误
            JsonArrayBuilder errors = Json.createArrayBuilder();
            for (ConstraintViolation<Developer> violation : violations) {
                errors.add(Json.createObjectBuilder().add("path", violation.getPropertyPath().toString())
                        .add("message", violation.getMessage()));
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(errors.build()).build();
        }


    }
}