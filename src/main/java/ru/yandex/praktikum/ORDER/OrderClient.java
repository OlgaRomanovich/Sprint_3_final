package ru.yandex.praktikum.ORDER;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.COURIER.ScooterRestClient;
import static io.restassured.RestAssured.given;

    public class OrderClient extends ScooterRestClient {

        private static final String ORDERS_PATH = "api/v1/orders/";

        @Step("Create order {order}")
        public ValidatableResponse createOrder(Order order) {
            return given()
                    .spec(getBaseSpec())
                    .body(order)
                    .log().all()
                    .when()
                    .post(ORDERS_PATH)
                    .then();
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

        @Step("Get order list")
        public ValidatableResponse getOrderList() {
            return given()
                    .spec(getBaseSpec())
                    .log().all()
                    .when()
                    .get("api/v1/orders")
                    .then();
        }
    }
