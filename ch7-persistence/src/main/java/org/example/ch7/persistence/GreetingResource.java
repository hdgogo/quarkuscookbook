package org.example.ch7.persistence;


import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/hello")
public class GreetingResource {

    @Inject
    AgroalDataSource defaultDatasource;

    @Inject
    @DataSource("user")
    AgroalDataSource userDataSource;

    @Inject
    @DataSource("mind")
    AgroalDataSource mindDataSource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try {
            defaultDatasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Hello RESTEasy";
    }
}