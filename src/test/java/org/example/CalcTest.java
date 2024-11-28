package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all");
    }

    @BeforeEach
    public void setUpEach(){
        System.out.println("before each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Проверка суммирования 1")
    @Timeout(5)
    @Tag("summ")
    void summ1(){
        Calc calculator = new Calc();
        int result = calculator.summ(1, 8);
        Assertions.assertEquals(9, result, "Не тот ответ ");
    }

    @RepeatedTest(4)
    @DisplayName("Проверка суммирования 2")
    @Timeout(5)
    @Tag("summ")
    void summ2(){
        Calc calculator = new Calc();
        int result = calculator.summ(4,3);
        Assertions.assertEquals(7, result, "Не тот ответ");
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем {2}")
    @CsvSource({"4, 5, 9", "-2, 5, 3", "0, 0, 0"})
    @DisplayName("Проверка суммирования 3")
    @Tag("summ")
    void summ3(int a, int b, int expectedResult) {
        Calc calculator = new Calc();
        int result = calculator.summ(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Проверка разности 1")
    @Timeout(5)
    @Tag("sub")
    void subtract1() {
        Calc obj = new Calc();
        int result = obj.subtract(10, 5);
        Assertions.assertEquals(5, result, "Не тот ответ");
    }

    @RepeatedTest(2)
    @DisplayName("Проверка разности 2")
    @Timeout(6)
    @Tag("sub")
    void subtract2() {
        Calc obj = new Calc();
        int result = obj.subtract(30, 7);
        Assertions.assertEquals(23, result, "Не тот ответ");
    }

    @ParameterizedTest(name = "#{index} - разность {0} и {1}, ожидаем {2}")
    @CsvSource({"22, 1, 21", "-1, 5, -6", "4, 6, -2"})
    @DisplayName("Проверка разности 3")
    @Tag("sub")
    void subtract3(int a, int b, int expectedResult) {
        Calc obj = new Calc();
        int result = obj.subtract(a, b);
        Assertions.assertEquals(expectedResult, result, "Не тот ответ");
    }

}