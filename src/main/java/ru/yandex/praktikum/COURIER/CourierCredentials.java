package ru.yandex.praktikum.COURIER;

public class CourierCredentials {
    private final String login;
    private final String password;
    public CourierCredentials (String login, String password) {
        this.login=login;
        this.password=password;
    }

public  CourierCredentials from(Courier courier) {
        return new CourierCredentials (courier.login, courier.password);
}
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

