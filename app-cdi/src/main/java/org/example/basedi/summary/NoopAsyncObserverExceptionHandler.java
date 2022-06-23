package org.example.basedi.summary;

import io.quarkus.arc.AsyncObserverExceptionHandler;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.EventContext;
import javax.enterprise.inject.spi.ObserverMethod;

@ApplicationScoped
public class NoopAsyncObserverExceptionHandler implements AsyncObserverExceptionHandler{

    @Override
    public void handle(Throwable throwable, ObserverMethod<?> observerMethod, EventContext<?> eventContext) {
        // 异常信息
        Log.info("exception is - " + throwable);
        // 事件信息
        Log.info("observer type is - " + observerMethod.getObservedType().getTypeName());
    }
}
