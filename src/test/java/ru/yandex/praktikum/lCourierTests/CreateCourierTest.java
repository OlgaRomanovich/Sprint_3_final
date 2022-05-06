package ru.yandex.praktikum.lCourierTests;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.COURIER.Courier;
import ru.yandex.praktikum.COURIER.CourierClient;
import ru.yandex.praktikum.COURIER.CourierCredentials;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateCourierTest {
    private CourierClient courierClient;
    Courier courier;
    private int courierId;
    public boolean responseText;


    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = new Courier("cucumber ", "12345", "Ivan");
    }

    @After
    public void tearDown() {
        ValidatableResponse loginResponse = courierClient.login(new CourierCredentials(courier.login, courier.password));
        courierId = loginResponse.extract().path("id");
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Cоздание курьера с корректными данными")
    public void createCourier() {
        ValidatableResponse createResponse = courierClient.create(courier);
        int statusCode = createResponse.extract().statusCode();
        responseText = createResponse.extract().path("ok");
        assertThat("Courier is created", statusCode, equalTo(201));
        assertThat("Response is correct", responseText, equalTo(true));

    }

    @Test
    @DisplayName("Cоздание курьера с существующим login")
    public void createCourierWithInvalidData() {
        ValidatableResponse validCourier = courierClient.create(courier);
        int statusCode1 = validCourier.extract().statusCode();
        assertThat("Courier is created", statusCode1, equalTo(201));
        Courier invalidCourier = new Courier("cucumber", "12345", "Oleg");
        ValidatableResponse createResponse = courierClient.create(invalidCourier);
        int statusCode = createResponse.extract().statusCode();
        String responseText1 = createResponse.extract().path("message");
        assertThat("Courier is not created", statusCode, equalTo(409));
        assertThat("Response is correct", responseText1, equalTo("Этот логин уже используется. Попробуйте другой."));
    }
}




