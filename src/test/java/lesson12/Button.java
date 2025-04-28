package lesson12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

public class Button {
    private String name;
    private SelenideElement selector;

    public Button(String name, SelenideElement selector){
        this.name = name;
        this.selector = selector;
    }
    @Step("Нажимаем на кнопку")
    public void buttonClick(){
        selector.shouldBe(Condition.visible, Duration.ofSeconds(4)).click();
    }

    @Step("Получаем имя кнопки")
    public String getButtonName(){
        return selector.shouldBe(Condition.visible, Duration.ofSeconds(4)).getText();
    }

    public String getName(){
        return name;
    }

    public SelenideElement getSelector(){
        return selector;
    }
}
