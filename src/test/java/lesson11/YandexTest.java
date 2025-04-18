package lesson11;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class YandexTest {

    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
    @BeforeAll
    public static void init(){
        setup();
    }
    @Test
    @DisplayName("Проверка лого после выполнения поиска в яндекс")
    void searchInYandex() {
        open("https://ya.ru/");
        $("input[class='search3__input mini-suggest__input']").shouldBe(Condition.visible).setValue("Selenide").pressEnter();
        $("a[class='HeaderLogo']").shouldBe(Condition.visible);
        $("path").shouldHave(attribute("fill", "#F8604A"));
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }

}
