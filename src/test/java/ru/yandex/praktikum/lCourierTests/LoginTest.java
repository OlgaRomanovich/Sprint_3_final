package ru.yandex.praktikum.lCourierTests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.COURIER.Courier;
import ru.yandex.praktikum.COURIER.CourierClient;
import ru.yandex.praktikum.COURIER.CourierCredentials;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginTest {
    private CourierClient courierClient;
    Courier courier;
    private int courierId;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = Courier.getRandom();
        courierClient.create(courier);
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Логин курьера с корректными данными")
    public void courierCanLoginWithValidCredentials() {
        ValidatableResponse loginResponse = courierClient.login(new CourierCredentials(courier.login, courier.password));
        int statusCode = loginResponse.extract().statusCode();
        courierId = loginResponse.extract().path("id");
        assertThat("Courier cannot login", statusCode, equalTo(SC_OK));
        assertThat("Courier ID is incorrect", courierId, is(not(0)));
    }

    @Test
    @DisplayName("Login with empty password")
    public void courierCanLoginWithEmptyPassword() {
        ValidatableResponse loginResponse = courierClient.login(new CourierCredentials(courier.login, ""));
        int statusCode = loginResponse.extract().statusCode();
        String responseText = loginResponse.extract().path("message");
        assertThat("Courier cannot login", statusCode, equalTo(400));
        assertThat("Response is correct", responseText, equalTo("Недостаточно данных для входа"));
    }
    @Test
    @DisplayName("Login with Invalid Credentials")
    public void courierCanLoginWithInvalidCredentials() {
        ValidatableResponse loginResponse = courierClient.login(new CourierCredentials(courier.login, "12345"));
        int statusCode = loginResponse.extract().statusCode();
        String responseText = loginResponse.extract().path("message");
        assertThat("Courier cannot login", statusCode, equalTo(404));
        assertThat("Response is correct", responseText, equalTo("Учетная запись не найдена"));
    }
}

