package org.example.ch4.config;


import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name="greeting.message") //注入greeting.message 属性的值
    String message;

    @ConfigProperty(name="greeting.upper-case", defaultValue = "true") // 将greeting.upper-case的默认值设置为“true”
    boolean uppercase;

    @ConfigProperty(name="greeting.suffix")
    List<String> suffixes;

    @ConfigProperty(name="greeting.color")
    String color;

    @ConfigProperty(name="greeting.vat")
    Percentage vat;

    //以程序化的方式访问配置属性
    @Inject    // 使用Inject CDI注解来注入配置实例
    Config config;

    @Inject
    GroupingConfiguration groupingConfiguration;

    @Inject
    NewGroupingConfiguration newGroupingConfiguration;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/optional")
    public String helloOptional(){
        return uppercase ? message.toUpperCase(): message;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/list")
    public String helloList(){
        return message + suffixes.get(1);
    }

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig(){
        config.getPropertyNames().forEach(p -> {
            Optional<String> v = config.getOptionalValue(p, String.class);
            System.out.println(p + ":" + v.orElse("null"));
        }); //循环打印属性值
        return config.getValue("greeting.message", String.class);
    }

    @GET
    @Path("/color")
    @Produces(MediaType.TEXT_PLAIN)
    public String color(){
        return color;
    }


    @GET
    @Path("/vat")
    @Produces(MediaType.TEXT_PLAIN)
    public String vat(){
        return Double.toString(vat.getPercentage());
    }

    @GET
    @Path("/groupingconfing")
    @Produces(MediaType.TEXT_PLAIN)
    public String groupingConfig(){
        groupingConfiguration.output.recipients.forEach(p -> System.out.println(p));
        return groupingConfiguration.message + groupingConfiguration.suffix;
    }


    @GET
    @Path("/newgroupingconfing")
    @Produces(MediaType.TEXT_PLAIN)
    public String newGroupingConfig(){
        return newGroupingConfiguration.host() + " " +newGroupingConfiguration.port()+ " "+ newGroupingConfiguration.log().suffix() + " "+ newGroupingConfiguration.log().enabled() + " "+newGroupingConfiguration.log().rotate();
    }

}