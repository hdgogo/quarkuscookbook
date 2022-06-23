package org.example.basedi.interceptor3;


import io.quarkus.logging.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@TrackClass
public class TrackClassInterceptor {

    @AroundInvoke
    Object execute(InvocationContext context) throws Exception {
        Log.info("from TrackClass");
        return context.proceed();
    }
}
