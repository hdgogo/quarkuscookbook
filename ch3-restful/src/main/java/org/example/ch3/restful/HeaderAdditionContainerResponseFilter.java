package org.example.ch3.restful;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 *  通过实现javax.ws.rs.container.ContainerRequestFilter 或  javax.ws.rs.container.ContainerResponseFilter 接口来实现一个过滤器
 *  这个过滤器只能适用与JAX-RS资源，而对响应式路由中无效
 */

@Provider   //将该类设置为扩展接口
public class HeaderAdditionContainerResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("X-Header", "Header adder by JAXRS Filter");
    }
}
