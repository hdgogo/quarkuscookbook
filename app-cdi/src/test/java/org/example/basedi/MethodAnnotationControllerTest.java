package org.example.basedi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class MethodAnnotationControllerTest {

    @Test
    public void testget(){
        given().when().get("/methodannotation")
                .then().statusCode(200)
                .body(containsString(HelloServiceImpl.class.getSimpleName()));
    }


}