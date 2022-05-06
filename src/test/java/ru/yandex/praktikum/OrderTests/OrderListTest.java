package ru.yandex.praktikum.OrderTests;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.COURIER.Courier;
import ru.yandex.praktikum.COURIER.CourierClient;
import ru.yandex.praktikum.COURIER.CourierCredentials;
import ru.yandex.praktikum.ORDER.Order;
import ru.yandex.praktikum.ORDER.OrderClient;
import java.util.LinkedHashMap;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderListTest {

    @Test
    @Description("Список заказов")
    @DisplayName("Список заказов")
    @TmsLink("TMS-4.1")
    @Issue("BUG-4.1")
    public void bodyReturnsOrdersListCorrectly() {
//       CourierClient courierClient = new CourierClient();
//        Courier courier = Courier.getRandom();
        //courierClient.create(courier);
        OrderClient orderClient= new OrderClient();

//        ValidatableResponse courierIdResponse = courierClient.login(new CourierCredentials(courier.login, courier.password));
//int courierId=courierIdResponse.extract().path("id");
//        Order order= new Order( "Naruto",
//                "Uchiha",
//                "Konoha, 142 apt.",
//                "4",
//                "+7 800 355 35 35",
//                5,
//                "2020-06-06",
//                "Saske, come back to Konoha",
//                new String [] {"BLACK"});
//        ValidatableResponse  trackId = orderClient.createOrder(order);
//        int t=trackId.extract().path("track");
//        ValidatableResponse orderIdResponse = orderClient.getOrderId(t);
//        Integer orderId= (Integer) ((LinkedHashMap) orderIdResponse.extract().path("order")).get("id");
//        ValidatableResponse acceptOrder= orderClient.acceptOrder(orderId, courierId);
        ValidatableResponse orderList = orderClient.getOrderList();
        List<String> orderListCheck=orderList.extract().path("orders");
        assertThat("Order List is null", orderListCheck, is(not(empty())));
        assertThat("No courierId found", orderListCheck, contains("id", "courierId", "firstName", "lastName", "adress", "metroStation", ""));
        //assertThat("No orderId found", orderList, contains(orderId));
        //assertThat("No orderId found", orderList, contains(trackOrder));
        //assertThat("No limit string found", orderList, contains("limit"));
        //assertThat("No page string found", orderList, contains("page"));

    }
}
