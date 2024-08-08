package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {
//اصنعلي مستخدم جديد بالزهر"
    public static User generateRandomUser() {
        String firstName = new Faker().name().firstName(); //name // تجيب اسم أول عشوائي.
        String lastName = new Faker().name().lastName(); // name
        String email = new Faker().internet().emailAddress(); // def maill
        String password = new Faker().internet().password(); // def passwprd
        User user = new User(firstName, lastName, email, password); // order dima
        return user;
    }
}
// donc dans ce cas  nst3mlha fel register api
//w nfs5 fel register api ;        User user = new User ("atef","ach","nourhoyda @gmail.com","esat32541");
// nbdlha bel User user = UserUtils.generateRandomUser();