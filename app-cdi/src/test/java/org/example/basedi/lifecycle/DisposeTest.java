package org.example.basedi.lifecycle;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class DisposeTest {

    @RepeatedTest(3)
    public void test() {
        given()
                .when().get("/resourcemanager")
                .then()
                .statusCode(200)
                // 检查body内容
                .body(is("success"));
    }
}
