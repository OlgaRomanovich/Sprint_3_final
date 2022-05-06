package ru.yandex.praktikum.ORDER;
import org.apache.commons.lang3.RandomStringUtils;

    public class Order {
        public final String firstName;
        public final String lastName;
        public final String address;
        public final String metroStation;
        public final String phone;
        public final int rentTime;
        public final String deliveryDate;
        public final String comment;
        public final String[] color;

        public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
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


        public static Order getRandomOrder(){

            final String firstName = RandomStringUtils.randomAlphabetic(10);
            final String lastName = RandomStringUtils.randomAlphabetic(10);
            final String address = RandomStringUtils.randomAlphabetic(10);
            final String metroStation = RandomStringUtils.randomAlphabetic(10);
            final String phone = RandomStringUtils.randomAlphabetic(10);
            final int rentTime = 6;
            final String deliveryDate = RandomStringUtils.randomAlphabetic(10);
            final String comment = RandomStringUtils.randomAlphabetic(10);
            final String[] color = new String[]{"BLACK", "GREY"};

            return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        }



    }

