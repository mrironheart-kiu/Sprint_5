package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    private Lion lion;
    @Spy
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion(feline, "Самец");
    }

    @Test
    @DisplayName("Метод Lion.getKittens() возвращает кол-во котят, равное 1")
    void getKittensReturnsOne() {
        int expectedResult = 1;
        int actualResult = lion.getKittens();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Конструктор Lion(String sex) выбрасывает Exception при некорректных вводных")
    void constructorLionSexThrowsExceptionTest() {
        Executable executable = () -> new Lion(feline,"Абра-Кадабра");

        assertThrows(
                Exception.class,
                executable
        );
    }

    @Test
    @DisplayName("Метод Lion.getFood() возвращает список питания для кошачих")
    void getFoodReturnsFoodListTest() throws Exception {
        List<String> expectedResult = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();

        assertEquals(expectedResult, actualResult);
    }
}