# ch3-restful Project

开发RESTful服务

## 创建一个简单的REST API端点

`JAX-RS`是Quarkus中用来定义REST端点的默认框架，所有的`JAX-RS`注解都已经正确地位于类路径上。通过使用HTTP动词注解（@GET， @POST，@PUT， @DELETE）来声明端点方法来监听的HTTP方法，通过使用@Path注解来定义端点的URI。

## 提取请求参数

常见注解@QueryParam, @HeaderParam, @FormParam, @MatrixParam， @CookieParam, 此外，使用@Context注解，可以注入其他与JAX-RS相关的元素。


## 使用HTTP响应状态码

`JAX-RS`规范使用javax.ws.rs.core.Response接口返回正确的HTTP响应状态码，并设置任何所需的信息，如响应内容，cookie或header。


## 启用跨源资源共享

使用quarkus.http.cors配置属性来启用跨源资源共享（CORS)
配置示例：

```properties
quarkus.http.cors=true
quarkus.http.cors.origins=http://example.com
quarkus.http.cors.methods=GET,PUT,POST,DELETE
quarkus.http.cors.headers=accept,authoirization,content-type,x-requested-with
```


## 使用响应式路由

有两种方法可以在Quarkus中使用响应式路由。第一种方法是直接使用io.vertx.ext.web.Router 类注册路由。
第二种方法是使用io.quarkus.vertx.web.Route注解的声明式方法。


## 拦截HTTP请求

有时需要在到达端点逻辑之前（例如：安全检查）或在响应被发给调用者之前（例如：压缩响应）对请求进行操作。可以使用Vert.x过滤器或JAX-RS过滤器来拦截HTTP请求。

第一种，使用`io.quarkus.vertx.http.runtime.filters.Filters` 过滤器， 该方法适用于servlet， JAX-RS资源和响应式路由；

也可以使用实现`javax.ws.rs.container.ContainerRequestFilter` 或`javax.ws.rs.container.ContainerResponseFilter`接口来实现过滤器； 该方法只适用于JAX-RS资源， 而不在响应式路由中