package org.example.ch3.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("developer")
public class DeveloperResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        return Response.created( //将响应状态码设置为201 ，以Location头作为URL进行创建
                        UriBuilder.fromResource(DeveloperResource.class) // 设置资源类的路径
                                .path(Long.toString(developer.getId()))  // 在Location头中设置开发者ID
                                .build()
                ).entity(developer) //将创建的开发者设置为响应内容
                .build();   //构建Response对象

    }


    public static class Developer {
        static long counter = 1;

        private long id;

        private String name;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void persist() {
            this.id = counter++;
        }
    }
}
