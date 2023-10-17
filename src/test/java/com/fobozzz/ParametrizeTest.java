package com.fobozzz;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizeTest extends TestBase {
    @BeforeEach
    void setup() {
        open("");
    }
    @CsvSource(value = {
            "selenide |, https://ru.selenide.org",
            "JUnit | https://junit.org"
    },
    delimiter = '|') // использование выбранного разделителя, если например в ТД есть запятая
    // OR
    // @CsvFileSource(resources = "/successfulSearchTest.csv", delimiter = '|') // в файле csv тоже нужно проставить разделитель '|'
    @ParameterizedTest (name = "Для поискового запроса: {0} в выдаче присутствует url: {1}")
    @Tags({
            @Tag("BLOCKER"), @Tag("WEB")
    })
    void successfulSearchTest(String searchQuery, String expextedUrl) {
        $("[name=q]").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expextedUrl));
    }
}

