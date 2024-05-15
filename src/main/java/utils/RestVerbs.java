package utils;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestVerbs {
    private static ValidatableResponse response;

    public static ValidatableResponse post(String serviceEndPoint,Object requestBody,Map<String, String> headers) {
        response = given()
                .urlEncodingEnabled(true)
                .filters(new ResponseLoggingFilter(),new ErrorLoggingFilter())
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(requestBody)
                .when().config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation().allowAllHostnames()))
                .post(serviceEndPoint)
                .then();
        return response;
    }

    public static ValidatableResponse get(String serviceEndPoint, Map<String, String> headers) {
        response = RestAssured
                .given().urlEncodingEnabled(true).log().all().headers(headers)
                .when().config(RestAssuredConfig.config().sslConfig((new SSLConfig()).relaxedHTTPSValidation().allowAllHostnames()))
                .get(serviceEndPoint).then();
        return response;
    }
}