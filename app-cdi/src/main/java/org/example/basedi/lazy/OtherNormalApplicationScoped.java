package org.example.basedi.lazy;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Startup
public class OtherNormalApplicationScoped {

    public OtherNormalApplicationScoped() {
        Log.info("Construction from " + this.getClass().getSimpleName());
    }

    public String ping() {
        Log.info("ping from OtherNormalApplicationScoped");
        return "ping from OtherNormalApplicationScoped";
    }
}
