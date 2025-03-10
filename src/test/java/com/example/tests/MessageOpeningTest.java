package com.example.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;
import com.example.pages.MessagesPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageOpeningTest extends BaseTest {
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }

    @Test
    @Tag("Messages")
    @DisplayName("Open messages test")
    public void openMessages() {
        MessagesPage messagesPage = feedPage.openMessages();
        assertThat(messagesPage.isOpen()).isTrue();
    }
}
