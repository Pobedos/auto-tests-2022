package com.example.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage {
    public static String url = "https://ok.ru";

    public static void openPage() {
        open(url);
        if (!isOpen()) {
            throw new UnsupportedOperationException();
        }
    }

    public static void logOff() {
        $(By.xpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]")).click();
        $(By.xpath("//a[@data-l='t,logout']")).click();
        $(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return $(By.id("viewImageLinkId")).shouldBe(appear).exists();
    }
}
