package org.example.basedi.interceptor3;


import io.quarkus.logging.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@TrackMethod
public class TrackMethodInterceptor {

    @AroundInvoke
    Object execute(InvocationContext context) throws Exception {
        Log.info("from TrackMethod");
        return context.proceed();
    }
}
