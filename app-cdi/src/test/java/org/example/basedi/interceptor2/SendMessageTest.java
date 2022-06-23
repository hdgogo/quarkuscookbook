package org.example.basedi.interceptor2;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Named;

@QuarkusTest
public class SendMessageTest {

    @Inject
    @Named("A")
    SayHello sayHelloA;


    @Inject
    @Named("B")
    SayHello sayHelloB;

    @Inject
    @Named("C")
    SayHello sayHelloC;


    @Test
    public void testSendMessage() {
        sayHelloA.hello();
        sayHelloB.hello();
        sayHelloC.hello();
    }

}
