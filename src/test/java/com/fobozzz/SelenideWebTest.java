package com.fobozzz;

import com.codeborne.selenide.CollectionCondition;
import com.fobozzz.domain.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWebTest extends TestBase {
    @BeforeEach
    void setup() {
        open("https://selenide.org/");
    }
    static Stream<Arguments> selenideLocaleTestDataProvider(){ // selenideLocaleTest - такое имя тут
        return Stream.of(
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"))
        );
    }
    @MethodSource("selenideLocaleTestDataProvider") // если имя совпадает с тестом, то указывать не нужно
    @ParameterizedTest
    void selenideLocaleTest(Locale siteLocale, List<String> expectedButtons) {
         $$("#languages a").find(text(siteLocale.name())).click();
         $$(".main-menu-pages a").filter(visible)
                 .shouldHave(CollectionCondition.texts(expectedButtons));
    }
}
