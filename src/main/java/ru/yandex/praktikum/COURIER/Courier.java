package ru.yandex.praktikum.COURIER;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class Courier {
    public String login;
    public String password;
    public String firstName;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }
    @Step("Create random courier")
    public static Courier getRandom() {
        final String courierLogin = RandomStringUtils.randomAlphabetic(10);
        final String courierPassword = RandomStringUtils.randomAlphabetic(10);
        final String courierFirstName = RandomStringUtils.randomAlphabetic(10);
        //Allure.addAttachment("Логин: ", login);
        //Allure.addAttachment("Пароль: ", password);
        //Allure.addAttachment("Имя: ", firstName);
        return new Courier(courierLogin, courierPassword, courierFirstName);
    }
}
