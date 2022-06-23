package org.example.basedi.interceptor2;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("C")
public class SayHelloC implements  SayHello{
    @Override
    @SendMessage
    @SendMessage(sendType = "email")
    public String hello() {
        Log.info("hello from C");
        return "hello from C";
    }
}
