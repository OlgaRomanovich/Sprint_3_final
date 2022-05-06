package ru.yandex.praktikum.ORDER;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.COURIER.ScooterRestClient;

import static io.restassured.RestAssured.given;

    public class OrderClient extends ScooterRestClient {

        private static final String ORDERS_PATH = "api/v1/orders/";

        @Step("Создаем заказ {order}")
        public ValidatableResponse createOrder(Order order) {
            return given()
                    .spec(getBaseSpec())
                    .body(order)
                    .log().all()
                    .when()
                    .post(ORDERS_PATH)
                    .then();
            //.assertThat()
            //.statusCode(201)
            //.extract()
            //.path("track");
        }

        @Step("Получить заказа по номеру")
        public ValidatableResponse getOrderId(int t) {
            return given()
                    .spec(getBaseSpec())
                    .param("t", t)
                    .log().all()
                    .when()
                    .get(ORDERS_PATH + "track")
                    .then();
        }

        @Step("Принять заказ")
        public ValidatableResponse acceptOrder(int orderId, int id) {
           return given()
                    .spec(getBaseSpec())
                   .param("orderId", orderId)
                    .log().all()
                    .when()
                    .put(ORDERS_PATH + "accept/"+id)
                    .then();
        }

        @Step("Получить список заказов")
        public ValidatableResponse getOrderList(int courierId) {
            return given()
                    .spec(getBaseSpec())
                    .param("courierId", courierId)
                    .log().all()
                    .when()
                    .get("api/v1/orders")
                    .then();
        }
    }
