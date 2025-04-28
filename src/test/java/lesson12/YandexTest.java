package lesson12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {
    private final String SEARCH_STRING = "Selenide";

    @BeforeAll
    public static void init(){
        Browser.setup();
        open("https://ya.ru/");
    }
    @Test
    @DisplayName("Выполнение поиска в яндекс и проверка лого")
    void logoCheck() {
        getPage().setSearchField(SEARCH_STRING);
        getPage().getSearchButton().buttonClick();
        getPage().getLogo().shouldBe(Condition.visible);
        getPage().getLogoColour().shouldHave(attribute("fill", "#F8604A"));
    }

    private YandexPage getPage(){
        return new YandexPage();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }
}
