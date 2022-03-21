package org.example.ch3.restful;


import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;


/**
 * 使用响应式路由
 * 使用Vertx的 io.vertx.ext.web.Router 路由器实例
 * 或者io.quarkus.vertx.web.Route 注解
 */
@ApplicationScoped   //将对象实例化到CDI容器中，其作用域为application
public class ApplicationRoutes {

    public void routes(@Observes Router router) {  // 提供Router对象来注册路由
        router.get("/ok")  //将 GET HTTP方法绑定到 “/ok”
                .handler(rc -> rc.response().end("OK from Route")); //逻辑处理

    }


    @Route(path="/declarativeok", methods = Route.HttpMethod.GET)  //设置HTTP路径和方法
    public void greetings(RoutingContext routingContext){  //RoutingContext获取请求信息
        String name = routingContext.request().getParam("name");  // 获取查询蚕食
        if (name == null){
            name = "world";
        }

        routingContext.response().end("OK "+ name + " you are right" ); //逻辑处理
    }
}
