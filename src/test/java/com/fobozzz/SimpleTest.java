package com.fobozzz;

import org.junit.jupiter.api.*;

//@Disabled ("Можно вставить id Bug из Jira") // можно вставить над классом что отключить все тесты на какую нить функциональность
@DisplayName ("Демо тесты")
public class SimpleTest {

    @Test
    @DisplayName("Демонстрационный тест для проверки того, как работают аннотации")
    void simpleTest() {
        Assertions.assertEquals(3, 2 + 1, "No Good");
    }

    @Test
    @Disabled ("Можно вставить id Bug из Jira")
    @DisplayName("Демо тест для печати")
    void printTest(){
        System.out.println("Тест Disable");
    }
}
