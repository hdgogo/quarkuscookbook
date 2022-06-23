package org.example.basedi.lifecycle;

import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@TrackLifeCycle
@Priority(Interceptor.Priority.APPLICATION + 1)
public class LifeCycleInterceptor {

    @AroundConstruct
    void execute(InvocationContext context) throws Exception {
        Log.info("start AroundConstruct");
        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.info("end AroundConstruct");
    }

    @PostConstruct
    public void doPostConstruct(InvocationContext ctx) {
        Log.info("life cycle PostConstruct");
    }

    @PreDestroy
    public void doPreDestroy(InvocationContext ctx) {
        Log.info("life cycle PreDestroy");
    }
}
