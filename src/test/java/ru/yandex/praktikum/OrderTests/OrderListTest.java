package ru.yandex.praktikum.OrderTests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.ORDER.OrderClient;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderListTest {

    @Test
    @Description("Order List")
    @DisplayName("Order List")
    @TmsLink("TMS-4.1")
    @Issue("BUG-4.1")
    public void bodyReturnsOrdersListCorrectly() {
        OrderClient orderClient = new OrderClient();
        ValidatableResponse orderList = orderClient.getOrderList();
        List<String> orderListCheck = orderList.extract().path("orders");
        assertThat("Order List is null", orderListCheck, is(not(empty())));

    }
}
