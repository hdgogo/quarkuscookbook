package org.example.basedi.lazy;


import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ChangeLazyLogicTest {

    @Inject
    NormalSingleton normalSingleton;

    @Inject
    NormalApplicationScoped normalApplicationScoped;

    @Inject
    OtherNormalApplicationScoped otherNormalApplicationScoped;

    @Test
    void ping() {
        Log.info("start invoke normalSingleton.ping");
        normalSingleton.ping();
        Log.info("start invoke normalApplicationScoped.ping");
        normalApplicationScoped.ping();
        Log.info("start invoke otherNormalApplicationScoped.ping");
        otherNormalApplicationScoped.ping();
    }
}
