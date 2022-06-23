package org.example.basedi.interceptor;


import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@TrackParams
public class TrackParamsDemo {

    public void hello(String name, int id) {
        Log.infov("Hello {0}, your id is {1}", name, id);
    }
}
