package org.example.basedi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class MethodAnnonationBean {

    @Produces
    @ApplicationScoped
    public HelloService getHelloService(){
        return new HelloServiceImpl();
    }
}
