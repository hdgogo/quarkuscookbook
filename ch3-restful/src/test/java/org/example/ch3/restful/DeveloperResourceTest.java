package org.example.ch3.restful;

import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static io.restassured.RestAssured.given;


@QuarkusTest
class DeveloperResourceTest {
    
    @Test
    public void testDeveloperEndpoint(){
        JsonObject object = new JsonObject("{\"name\":\"hongda\"}");
        object.put("sex", "男");
        System.out.println(object.toString());
        given().when().contentType("application/json").body(object.toString()).post("/developer")
                .then().statusCode(201).body(containsString("hongda"));
    }

}