package org.example.basedi;


import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/methodannotation")
public class MethodAnnotationController {

    @Inject
    HelloService helloService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return String.format("Hello RESTEasy, %s, %s",
                LocalDateTime.now(),
                helloService.hello());
    }

}
