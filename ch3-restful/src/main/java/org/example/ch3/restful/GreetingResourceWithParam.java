package org.example.ch3.restful;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("hello-param")
public class GreetingResourceWithParam {

    public static enum Order {
        desc, asc;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context UriInfo uriInfo, // 获取请求的UriInfo。 UriInfo是JAX-RS的一部分，允许获取应用和请求的URI信息)
                        @QueryParam("order") Order order, // 获取Enum类型，名为order的查询参数
                        @NotBlank @HeaderParam("authorization") String authorization //获取与bean验证集成的名为authorization的头部参数
    ) {
        return String.format("URI: %s - Order %s - Authorization: %s", uriInfo.getAbsolutePath(), order, authorization);
    }
}
