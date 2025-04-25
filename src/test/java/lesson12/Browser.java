package lesson12;

import com.codeborne.selenide.Configuration;

public class Browser {

    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
}
