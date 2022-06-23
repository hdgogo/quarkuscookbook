package org.example.basedi.interceptor;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@HandleConstruction
public class HandleonstructionDemo {

    public HandleonstructionDemo() {
        super();
        Log.infov("construction of {0}", HandleonstructionDemo.class.getSimpleName());
    }

    public void hello() {
        Log.info("hello world!");
    }
}
