package org.example.basedi.lazy;


import io.quarkus.logging.Log;

import javax.inject.Singleton;

@Singleton
public class NormalSingleton {

    public NormalSingleton() {
        Log.info("Construction from " + this.getClass().getSimpleName());
    }

    public String ping() {
        Log.info("ping from NormalSingleton");
        return "ping from NormalSingleton";
    }
}
