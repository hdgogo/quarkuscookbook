package org.example.basedi.interceptor;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class InterceptorTest {

    @Inject
    HandleErrorDemo handleErrorDemo;

    @Test
    public void testHandleError() {
        handleErrorDemo.executeThrowError();
    }

    @Inject
    HandleonstructionDemo handleonstructionDemo;

    @Test
    public void testHandleonstruction() {
        handleonstructionDemo.hello();
    }

    @Inject
    TrackParamsDemo trackParamsDemo;

    @Test
    public void testTrackParams() {
        trackParamsDemo.hello("Tom", 101);
    }


    @Inject
    ContextDataDemo contextDataDemo;

    @Test
    public void testContextData() {
        contextDataDemo.hello();
    }
}
