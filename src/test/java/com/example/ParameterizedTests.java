package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTests {
    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    @DisplayName("Метод Lion.doesHaveMane() возвращает флаг наличия гривы у льва")
    void doesHaveManeTest(String sex, boolean expectedResult) throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actualResult = lion.doesHaveMane();

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "200", "5986"})
    @DisplayName("Метод Feline.getKittens(int kittensCount) возвращает указанное кол-во котят")
    void getKittensReturnsProvidedCount(int kittensCount) {
        int expectedResult = kittensCount;
        int actualResult = feline.getKittens(kittensCount);

        assertEquals(expectedResult, actualResult);
    }
}
