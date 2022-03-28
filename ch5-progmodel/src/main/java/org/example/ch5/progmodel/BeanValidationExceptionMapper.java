package org.example.ch5.progmodel;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider   //@Provider设置了一个可由JAX-RS 运行时发现的扩展接口实现
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> { //javax.ws.rs.ext.ExceptionMapper 用于将异常转化为一个javax.ws.rs.core.Response
    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(createErrorMessage(e))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private JsonArray createErrorMessage(ConstraintViolationException e){
        JsonArrayBuilder errors = Json.createArrayBuilder();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(Json.createObjectBuilder().add("path", violation.getPropertyPath().toString())
                    .add("message", violation.getMessage()));
        }
        return errors.build();
    }
}
