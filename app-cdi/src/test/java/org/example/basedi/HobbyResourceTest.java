package org.example.basedi;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class HobbyResourceTest {

    @Test
    public void testHello(){
        given()
                .when().get("/actions")
                .then()
                .statusCode(200)
                .body(containsString("Hello RESTEasy"));
    }

}