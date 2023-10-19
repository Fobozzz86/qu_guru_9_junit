package homework;

import com.codeborne.selenide.Configuration;
import homework.data.CategoriesDesktop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CategoriesDesktopWithCsvSourceTest {
    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        open("https://dikidi.ru/ru");
    }

        static Stream<Arguments> dikidiCategoriesTestDataProvider(){
        return Stream.of(
                Arguments.of(CategoriesDesktop.КРАСОТА, List.of("Парикмахерские услуги", "Ресницы", "Барбершоп", "Татуаж, тату")),
//                Arguments.of(CategoriesDesktop.SPORT, List.of("Фитнес")),
//                Arguments.of(CategoriesDesktop.HEALTH, List.of("Стоматология")),
                Arguments.of(CategoriesDesktop.ЖИВОТНЫЕ, List.of("Груминг"))
        );
    }
        @MethodSource("dikidiCategoriesTestDataProvider")
        @ParameterizedTest(name = "Для Блока {0} отображаются категории {1}")
        void dikidiCategoriesTest(CategoriesDesktop categories, List<String> blockOfCategories) {
            // установка нужного города
            $("a.js.city").click();
            $("input[type=search]").setValue("самара");
            $$(".nowrap").find(text("Самара, Самарская область, Россия")).click();


            // клик на категорию
            $$("li[data-name]").filter(visible)
                    .find(text(categories.name())).click();
            // проверка что есть категории
           $$(".text").shouldHave(texts(blockOfCategories));
                 }
    }
