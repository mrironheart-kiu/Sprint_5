package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatTest {
    private Cat cat;
    @Spy
    private Feline feline;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("Метод Cat.getSound() возвращает голос \"Мяу\" для кошки")
    void getSoundReturnsSoundTest() {
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Cat.getFood() возвращает список питания для кошки")
    void getFoodReturnsFoodListTest() throws Exception {
        List<String> expectedResult = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = cat.getFood();

        assertEquals(expectedResult, actualResult);
    }
}