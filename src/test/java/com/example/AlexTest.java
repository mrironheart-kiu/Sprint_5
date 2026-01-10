package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlexTest {
    private Alex alex;
    @Spy
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    @DisplayName("Метод Alex.getFriends() возвращает список друзей льва Алекса")
    void getFriendsReturnsFriendsListTest() {
        List<String> expectedResult = new ArrayList<>(List.of("Марти", "Глория", "Мелман"));
        List<String> actualResult = alex.getFriends();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Alex.getPlaceOfLiving() возвращает наименование места проживания льва Алекса")
    void getPlaceOfLivingReturnsPlaceOfLivingNameTest() {
        String expectedResult = "Нью-Йоркский зоопарк";
        String actualResult = alex.getPlaceOfLiving();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Alex.getKittens() возвращает кол-во котят, равное 0")
    void getKittensReturnsZero() {
        int expectedResult = 0;
        int actualResult = alex.getKittens();

        assertEquals(expectedResult, actualResult);
    }
}