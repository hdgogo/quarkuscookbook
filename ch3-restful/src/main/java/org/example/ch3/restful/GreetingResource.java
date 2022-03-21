package org.example.ch3.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")  //确定当前资源的URI路径
public class GreetingResource {

    @GET  //响应HTTP GET 请求
    @Produces(MediaType.TEXT_PLAIN)  //定义返回的媒体类型
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST  //响应HTTP POST 请求
    @Consumes(MediaType.TEXT_PLAIN) //定义可接受的媒体类型
    public void create(String message){
        System.out.println("Create");
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message){
        System.out.println("update");
        return  message;
    }

    @DELETE
    public void deleta(){
        System.out.println("Delete");
    }

    @LOCK  // 绑定自定义的HTTP方法 LOCK
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id){
        return id + " locked";
    }
}