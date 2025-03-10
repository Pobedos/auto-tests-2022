package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import com.example.pages.FeedPage;
import com.example.pages.LoginPage;
import com.example.utils.User;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private static final String BASE_URL = "https://ok.ru";

    static User createUser() throws IOException {
        //Создайте credentials.txt перед запуском
        //1 строка - логин
        //2 строка - пароль
        BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
        return User.builder()
                .setLogin(reader.readLine())
                .setPassword(reader.readLine())
                .build();
    }

    @BeforeAll
    public static void init() throws IOException {
        Configuration.baseUrl = BASE_URL;
        open("/");
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }

//    protected static void authorize() throws IOException {
//        LoginPage.openPage()
//                .login(createUser());
//    }
//
//    protected static void logOff() {
//        FeedPage.openPage()
//                .logout();
//    }

    protected void goToUrl(String url) {
        open(url);
    }
}
