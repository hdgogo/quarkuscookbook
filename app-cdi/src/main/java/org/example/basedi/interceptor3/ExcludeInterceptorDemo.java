package org.example.basedi.interceptor3;

import io.quarkus.arc.NoClassInterceptors;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@TrackClass
public class ExcludeInterceptorDemo {

    public void test0() {
        Log.info("from test0");
    }

    @NoClassInterceptors
    @TrackMethod
    public void test1() {
        Log.info("from test1");
    }
}
