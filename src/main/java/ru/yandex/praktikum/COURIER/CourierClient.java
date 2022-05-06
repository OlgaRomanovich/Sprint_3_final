package ru.yandex.praktikum.COURIER;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class CourierClient extends ScooterRestClient {
    private static final String COURIER_PATH= "api/v1/courier/";
    @Step("Register courier")
    public ValidatableResponse create(Courier courier){
        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then();
    }

    @Step ("Login courier")
    public ValidatableResponse login(CourierCredentials creds) {
        return given()
                .spec(getBaseSpec())
                .body(creds)
                .when()
                .post(COURIER_PATH + "login")
                .then();
    }

    @Step ("Delete courier {id}")
    public ValidatableResponse delete(int id) {
        return given().log().all()
                .spec(getBaseSpec())
                .when()
                .delete(COURIER_PATH +id)
                .then();
    }
}
