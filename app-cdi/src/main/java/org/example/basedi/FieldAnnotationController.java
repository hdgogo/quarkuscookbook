package org.example.basedi;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("fieldannotation")
public class FieldAnnotationController {

    @Inject @FieldAnn
    OtherServiceImpl otherServiceImpl;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return String.format("Hello RESTEasy, %s, %s",
                LocalDateTime.now(),
                otherServiceImpl.hello());
    }
}
