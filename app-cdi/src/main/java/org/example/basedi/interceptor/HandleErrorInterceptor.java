package org.example.basedi.interceptor;


import io.quarkus.arc.Priority;
import io.quarkus.logging.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@HandleError
@Interceptor
@Priority(Interceptor.Priority.APPLICATION +1)
/**
 * @Priority 注解的作用是设定HandleError拦截器的优先级(值越小优先级越高)，可以同时用多个拦截器拦截同一个方法
 * @AroundInvoke 注解的作用，是表明execute会在拦截bean方法时被调用
 * proceed方法的作用，并非是执行被拦截的方法，而是执行下一个拦截器，直到最后一个拦截器才会执行被拦截的方法
 * 可以从入参context处取得被拦截实例和方法的信息
 */
public class HandleErrorInterceptor {

    @AroundInvoke
    Object execute(InvocationContext context) {
        try {
            // 注意proceed方法的含义：调用下一个拦截器，直到最后一个才会执行被拦截的方法
            return context.proceed();
        } catch (Exception exception) {
            Log.errorf(exception,
                    "method error from %s.%s\n",
                    context.getTarget().getClass().getSimpleName(),
                    context.getMethod().getName());
        }
        return null;
    }
}
