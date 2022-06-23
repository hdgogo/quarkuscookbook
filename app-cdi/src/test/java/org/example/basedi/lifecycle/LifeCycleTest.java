package org.example.basedi.lifecycle;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class LifeCycleTest {

    @Inject
    Hello hello;

    @Test
    public void testLifyCycle() {
        hello.helloWorld();
    }
}
