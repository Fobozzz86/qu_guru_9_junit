package com.fobozzz;

import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("WEB - тесты для демонстрации JUnit")
public class WebTest extends TestBase {

    @BeforeEach
    void setup() {
        open("");
    }
    @Test
    /* чтобы запустить тесты по тегу в терминале: gradle test -PincludeTags="@Tag"
     см. в build.gradle или на странице:
    https://ru.stackoverflow.com/questions/1534213/%d0%9a%d0%b0%d0%ba-%d0%b7%d0%b0%d0%bf%d1%83%d1%81%d0%ba%d0%b0%d1%82%d1%8c-%d1%82%d0%b5%d1%81%d1%82%d1%8b-%d0%bf%d0%be-%d0%bf%d0%b0%d0%bf%d0%ba%d0%b0%d0%bc-%d0%b8%d0%bb%d0%b8-%d0%bf%d0%be-%d1%82%d0%b5%d0%b3%d0%b0%d0%bc */
    @Tags({
            @Tag("BLOCKER"), @Tag("WEB")
    })
    @DisplayName("Для поискового запроса 'selenide' в выдаче присутствует url 'https://ru.selenide.org'")
    void successfulSearchSelenideTest() {
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }
    @Test
    @Tags({
            @Tag("BLOCKER"), @Tag("WEB")
    })
    @DisplayName("Для поискового запроса 'junit' в выдаче присутствует url 'https://junit.org'")
    void successfulSearchJUnitTest() {
        $("[name=q]").setValue("junit").pressEnter();
        $("[id=search]").shouldHave(text("https://junit.org"));
    }
    @Test
    @Tags({
            @Tag("BLOCKER"), @Tag("WEB")
    })
    @DisplayName("Для поискового запроса 'selenide' и нажимается кнопка 'Мне повезет'")
    void fartTest() {
        $("[name=q]").setValue("selenide");
        $$("input[name='btnI']").filter(visible)
                .first()
                .click();

        WebDriverConditions.currentFrameUrlContaining("selenide.org");
    }
}
