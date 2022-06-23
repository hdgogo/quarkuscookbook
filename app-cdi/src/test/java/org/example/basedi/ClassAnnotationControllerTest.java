package org.example.basedi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


@QuarkusTest
class ClassAnnotationControllerTest {

    @Test
    public void testHello(){
        given().when().get("/classannotation")
                .then()
                .statusCode(200)
                .body(containsString(ClassAnnotationBean.class.getSimpleName()));
    }

}