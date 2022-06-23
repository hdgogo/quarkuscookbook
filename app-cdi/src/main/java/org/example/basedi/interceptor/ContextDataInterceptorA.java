package org.example.basedi.interceptor;


import io.quarkus.arc.Priority;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@ContextData
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 1)
public class ContextDataInterceptorA extends  BaseContextDataInterceptor{

    @AroundInvoke
    Object execute(InvocationContext context) throws Exception {
        return super.execute(context);
    }
}
