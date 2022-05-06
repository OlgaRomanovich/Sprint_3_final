package ru.yandex.praktikum.OrderTests;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.ORDER.Order;
import ru.yandex.praktikum.ORDER.OrderClient;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class OrderTest {
    private OrderClient orderClient;
    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }
    @Test
    @Step ("Создание заказа")
    @Description("Создание заказа")
    @DisplayName("Создание заказа")
    @TmsLink("TMS-3.1")
    @Issue("BUG-3.1")
    public void orderCanBeCreatedWithValidData() {
        Order order= new Order( "Naruto",
                 "Uchiha",
                 "Konoha, 142 apt.",
                 "4",
                 "+7 800 355 35 35",
                 5,
                 "2020-06-06",
                 "Saske, come back to Konoha",
                new String [] {"BLACK"});
        ValidatableResponse createResponse = orderClient.createOrder(order);
        int response = createResponse.extract().path("track");
        assertThat("Response is correct", response, is(not(0)));

    }
}