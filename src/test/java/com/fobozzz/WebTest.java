package com.fobozzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("WEB - тесты для демонстрации JUnit")
public class WebTest extends TestBase{

    @Test
    /* чтобы запустить тест по тегу см. в build.gradle или на странице:
    https://ru.stackoverflow.com/questions/1534213/%d0%9a%d0%b0%d0%ba-%d0%b7%d0%b0%d0%bf%d1%83%d1%81%d0%ba%d0%b0%d1%82%d1%8c-%d1%82%d0%b5%d1%81%d1%82%d1%8b-%d0%bf%d0%be-%d0%bf%d0%b0%d0%bf%d0%ba%d0%b0%d0%bc-%d0%b8%d0%bb%d0%b8-%d0%bf%d0%be-%d1%82%d0%b5%d0%b3%d0%b0%d0%bc */
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }


}
