package lesson12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class YandexPage {
    private final SelenideElement SEARCH_FIELD = $("input[class='search3__input mini-suggest__input']");
    private final SelenideElement LOGO = $("a[class='HeaderLogo']");
    private final SelenideElement LOGO_COLOUR = $("path");

    public SelenideElement getSearchField(){
        return SEARCH_FIELD;
    }

    public SelenideElement getLogo(){
        return LOGO;
    }

    public SelenideElement getLogoColour(){
        return LOGO_COLOUR;
    }
}
