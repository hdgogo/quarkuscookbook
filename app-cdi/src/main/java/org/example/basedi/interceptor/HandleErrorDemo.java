package org.example.basedi.interceptor;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

@ApplicationScoped
@HandleError
/**
 * 使用拦截器，拦截器使用起来很简单：用HandleError修饰bean即可
 */
public class HandleErrorDemo {

    public void executeThrowError() {
        throw new IllegalArgumentException("this is business logic exception");
    }
}
