package org.example.ch5.progmodel;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(HelloWorldQuarkusTestResourceLifecycleManager.class)
public class HelloWorldTestResource {
}
