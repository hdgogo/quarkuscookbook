package org.example.basedi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


@QuarkusTest
public class RequestScopeControllerTest {

    @RepeatedTest(10)
    public void testGetEndpoint() {
        given()
                .when().get("/requestscope")
                .then()
                .statusCode(200)
                // 检查body内容，是否含有ClassAnnotationBean.hello方法返回的字符串
                .body(containsString("from " + RequestScopeBean.class.getSimpleName()));
    }

}