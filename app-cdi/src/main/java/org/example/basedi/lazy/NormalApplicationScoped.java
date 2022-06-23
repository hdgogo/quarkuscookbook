package org.example.basedi.lazy;


import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class NormalApplicationScoped {

    public NormalApplicationScoped() {
        Log.info("Construction from " + this.getClass().getSimpleName());
    }

    public String ping() {
        Log.info("ping from NormalApplicationScoped");
        return "ping from NormalApplicationScoped";
    }

    /**
     * 消费quarkus框架启动事件
     * @param event
     */
    void startup(@Observes StartupEvent event){
        Log.info("receive StartEvent");
    }
}
