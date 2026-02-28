package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {
    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    @DisplayName("Метод Feline.eatMeat() возвращает список питания для кошачих")
    void eatMeatReturnsFoodListTest() throws Exception {
        List<String> expectedResult = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = feline.eatMeat();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Feline.getFamily() возвращает название семейства - \"Кошачьи\"")
    void getFamilyReturnsFamilyNameTest() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Feline.getKittens() возвращает кол-во котят, равное 1")
    void getKittensReturnsOneTest() {
        int expectedResult = 1;
        int actualResult = feline.getKittens();

        assertEquals(expectedResult, actualResult);
    }
}