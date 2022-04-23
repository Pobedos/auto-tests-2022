package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchForFriendTest extends BaseTest {

    @ParameterizedTest
    @Tag("Friends")
    @DisplayName("Find non existent friends test")
    @MethodSource("provideNonExistentFriends")
    public void findNonExistentFriendTest(String nonExistentFriendName) {
        FeedPage.openPage();
        assertThat(new FeedPage()
                .openFriends()
                .searchPerson(nonExistentFriendName)
                .friendNotFound()).isTrue();
    }

    private static Stream<Arguments> provideNonExistentFriends() {
        return Stream.of(
                Arguments.of("Пивень"),
                Arguments.of("ПивПивыч"),
                Arguments.of("Пивчанский")
        );
    }
}
