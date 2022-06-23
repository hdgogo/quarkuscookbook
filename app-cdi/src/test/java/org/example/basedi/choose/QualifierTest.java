package org.example.basedi.choose;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Named;

@QuarkusTest
public class QualifierTest {

    @Inject
    //@MyQualifier("")
    //@Named("B")
    HelloQualifier helloQualifier;


    @Test
    public void testQualifier(){
        Assertions.assertEquals("Hello " + HelloQualifierA.class.getSimpleName(), helloQualifier.hello());
    }
}
