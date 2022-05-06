package ru.yandex.praktikum.OrderTests;

import io.qameta.allure.Step;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.ORDER.Order;
import ru.yandex.praktikum.ORDER.OrderClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class OrderParameterizedTest {
    private OrderClient orderClient;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String[] color;

    public OrderParameterizedTest(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;

    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}")

    public static Object[][] getOrderData() {
        //Order order = Order.getRandomOrder();
        return new Object[][]{
                {"testFirstName1", "testLastname1", "testAddress1", "metroStationTest1", "phoneTest1", 6, "10-10-2022", "commentTest1", new String[]{"BLACK"}},
                {"testFirstName2", "testLastname2", "testAddress2", "metroStationTest2", "phoneTest2", 6, "11-10-2022", "commentTest2", new String[]{}},
                {"testFirstName3", "testLastname3", "testAddress3", "metroStationTest3", "phoneTest3", 6, "12-10-2022", "commentTest3", new String[]{"BLACK", "GREY"}}
        };
    }

    @Test
    @Step ("")
    public void orderCanBeCreated() {
        orderClient = new OrderClient();
        Order orderCanBeCreated = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        ValidatableResponse responseCode = orderClient.createOrder(orderCanBeCreated);
        int statusCode = responseCode.extract().statusCode();
        assertThat("Order can not create", statusCode, equalTo(201));
    }
}

