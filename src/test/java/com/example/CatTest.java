package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatTest {
    private Cat cat;
    @Mock
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
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = cat.getFood();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Cat.getFood() вызывает метод Feline.eatMeat() один раз")
    void getFoodCallsFelineEatFoodMethodOnceTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        cat.getFood();

        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}