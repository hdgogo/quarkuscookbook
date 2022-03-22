package org.example.ch3.restful;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void testHelloEndpointPost(){
        given().when().contentType("text/plain").post("/hello")
                .then().statusCode(204);
    }


    @Test
    public void testHelloEndpointPut(){
        given().when().contentType("text/plain").body("put method").put("/hello")
                .then().statusCode(200).body(is("put method"));
    }

    @Test
    public void testHelloEndPointDelete(){
        given().when().delete("/hello").then().statusCode(204);
    }



}