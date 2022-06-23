package org.example.basedi.interceptor;


import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextData
public class ContextDataDemo {
    public void hello() {
        Log.info("Hello world!");
    }
}
