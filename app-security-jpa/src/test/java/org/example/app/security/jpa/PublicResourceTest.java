package org.example.app.security.jpa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PublicResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/public")
          .then()
             .statusCode(200)
             .body(is("Public"));
    }

}