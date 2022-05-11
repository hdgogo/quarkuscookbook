package org.example.ch6.buildpack;

import io.quarkus.runtime.annotations.CommandLineArguments;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @CommandLineArguments //注入命令行参数
    String[] args;



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return args[0];
    }
}