package lesson15.front;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FormTests {

    private final PracticeFormPage formPage = new PracticeFormPage();

    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x1024";
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 60000;
    }

    @BeforeEach
    void openPage() {
        setup();
        formPage.openPage();
    }

    @Test
    @DisplayName("Проверка отправки формы без заполнения обязательных полей")
    void testSubmitEmptyForm() {
        formPage.submit();
        assertFalse(formPage.isSubmissionSuccessful(), "Форма не должна быть отправлена без обязательных полей");

        String errorValidationColourFields = "rgb(220, 53, 69)";
        String errorValidationColourRadio = "rgba(220, 53, 69, 1)";

        // Цвет обязательных полей
        assertEquals(errorValidationColourFields, formPage.getFirstNameColour(), "First Name должен быть красным");
        assertEquals(errorValidationColourFields, formPage.getLastNameColour(), "Last Name должен быть красным");
        assertEquals(errorValidationColourFields, formPage.getMobileColour(), "Mobile должен быть красным");
        assertEquals(errorValidationColourRadio, formPage.getGenderColour(), "Gender должен быть красным");

    }

    @Test
    @DisplayName("Проверка заполнения только обязательных полей")
    void testFillRequiredFieldsOnly() {
        formPage.fillRequiredFields();
        formPage.submit();
        assertTrue(formPage.isSubmissionSuccessful(), "Форма должна успешно отправиться при заполнении только обязательных полей");

        String validationColourFields = "rgb(40, 167, 69)";
        String validationColourRadio = "rgba(40, 167, 69, 1)";

        // Цвет обязательных полей
        assertEquals(validationColourFields, formPage.getFirstNameColour(), "First Name должен быть зеленым");
        assertEquals(validationColourFields, formPage.getLastNameColour(), "Last Name должен быть зеленым");
        assertEquals(validationColourFields, formPage.getMobileColour(), "Mobile должен быть зеленым");
        assertEquals(validationColourRadio, formPage.getGenderColour(), "Gender должен быть зеленым");


    }

    @Test
    @DisplayName("Проверка корректного заполнения всех полей")
    void testFillAllFields() {
        formPage.fillAllFields();
        formPage.submit();
        assertTrue(formPage.isSubmissionSuccessful(), "Форма должна успешно отправиться при заполнении всех полей");
    }

    @AfterEach
    public void takeScreenshotAfterTest() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        Selenide.screenshot("after_each_" + timestamp);
    }
}
