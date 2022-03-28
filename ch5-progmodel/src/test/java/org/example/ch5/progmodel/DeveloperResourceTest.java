package org.example.ch5.progmodel;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class DeveloperResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/developer")
          .then()
             .statusCode(200);
             //.body(is("Hello from RESTEasy Reactive"));
    }

}