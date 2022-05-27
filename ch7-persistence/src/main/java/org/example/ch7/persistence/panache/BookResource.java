package org.example.ch7.persistence.panache;


import io.quarkus.hibernate.orm.panache.Panache;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/book")
public class BookResource {




    @Inject
    Validator validator;

    @GET
    public List<Book> list(){
        return Book.listAll();
    }

    @Path("/manual-validation")
    @POST
    public Result tryMeManualValidation(Book book) {
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (violations.isEmpty()) {
            return new Result("Book is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }


    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id){
        Book book = Book.findById(id);
        if (book != null){
            return Response.ok(book).build();
        }else{
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }



    @POST
    @Transactional
    public Response create(Book book){
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (violations.isEmpty()) {
            book.persist();
            return Response.created(URI.create("/book/"+book.id)).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(new Result(violations)).build();
        }
    }



    public static class Result {

        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        private String message;
        private boolean success;

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }

    }
}
