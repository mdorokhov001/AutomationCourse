package lesson12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class YandexPage {
    private final Field SEARCH_FIELD = new Field("Поле поиска Яндекс",
            $("input[class='search3__input mini-suggest__input']")) ;
    private final Button SEARCH_BUTTON = new Button("Кнопка поиска",
            $("button[type=\"submit\"]"));
    private final SelenideElement LOGO = $("a[class='HeaderLogo']");
    private final SelenideElement LOGO_COLOUR = $("path");

    public Field getSearchField(){
        return SEARCH_FIELD;
    }

    public void setSearchField(String str){
        SEARCH_FIELD.setField(str);
    }

    public SelenideElement getLogo(){
        return LOGO;
    }

    public SelenideElement getLogoColour(){
        return LOGO_COLOUR;
    }

    public Button getSearchButton(){
        return SEARCH_BUTTON;
    }
}
