package org.example.ch5.progmodel;


import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@LogEvent
@Interceptor
public class LogEventInterceptor {

    static List<Event> events = new ArrayList<>();


    @AroundConstruct
    public Object logEvent(InvocationContext ctx) throws Exception{
        events.add(new Event(ctx.getMethod().getName(), Arrays.deepToString(ctx.getParameters())));
        return ctx.proceed();
    }

    private static class Event {
        private String method;
        private String params;

        public Event(String method, String params) {
            this.method = method;
            this.params = params;
        }
    }
}
