package org.example.basedi.summary;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class EventExceptionHandlerTest {

    @Inject
    TestEventProducer testEventProducer;

    @Test
    public void testAsync() throws InterruptedException {
        testEventProducer.asyncProduce();
    }
}
