package org.example.basedi.interceptor2;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("A")
public class SayHelloA implements SayHello{
    @Override
    @SendMessage
    public String hello() {
        Log.info("hello from A");
        return "hello from A";
    }
}
