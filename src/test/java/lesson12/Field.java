package lesson12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

public class Field {
    private String name;
    private SelenideElement selector;

    public Field(String name, SelenideElement selector){
        this.name = name;
        this.selector = selector;
    }
    @Step("Заполняем поле")
    public void setField(String str){
        selector.shouldBe(Condition.visible, Duration.ofSeconds(4)).setValue(str);
    }

    public String getName(){
        return name;
    }

    public SelenideElement getSelector(){
        return selector;
    }
}
