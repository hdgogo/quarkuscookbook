package org.example.basedi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


@QuarkusTest
public class FieldAnnotationControllerTest {

    @Test
    public void testget(){
        given().when().get("/fieldannotation")
                .then().statusCode(200)
                .body(containsString(OtherServiceImpl.class.getSimpleName()));
    }

}