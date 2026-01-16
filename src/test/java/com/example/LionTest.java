package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    private Lion lion;
    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion(feline, "Самец");
    }

    @Test
    @DisplayName("Метод Lion.getKittens() возвращает кол-во котят, равное 1")
    void getKittensReturnsOneTest() {
        int expectedResult = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Lion.getKittens() вызывает метод Feline.getKittens() один раз")
    void getKittensCallsFelineGetKittensMethodOnceTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        lion.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    @DisplayName("Конструктор Lion(String sex) выбрасывает Exception при некорректных вводных")
    void constructorLionSexThrowsExceptionTest() {
        Executable executable = () -> new Lion(feline, "Абра-Кадабра");

        assertThrows(
                Exception.class,
                executable
        );
    }

    @Test
    @DisplayName("Метод Lion.getFood() возвращает список питания для кошачих")
    void getFoodReturnsFoodListTest() throws Exception {
        List<String> expectedResult = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Метод Lion.getFood() вызывает метод Feline.getFood(\"Хищник\") один раз")
    void getFoodCallsTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion.getFood();

        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}