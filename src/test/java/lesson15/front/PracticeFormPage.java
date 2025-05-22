package lesson15.front;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private PracticeFormPageElements elements;
    private TestData testData;

    private Map<String, String> testDataMap;

    public void openPage() {
        System.out.println("Открытие формы");
        open("https://demoqa.com/automation-practice-form");
        System.out.println("Форма открыта, начинается проверка наличия элементов");
        elements = new PracticeFormPageElements();
        elements.firstNameInput.shouldBe(visible);
        System.out.println("Форма загружена");
        testData = new TestData("src/test/resources/testdata_front.properties");
        System.out.println("Тестовые данные загружены");
    }

    public void fillRequiredFields() {
        System.out.println("Заполняются обязательные поля");
        elements.firstNameInput.setValue(testData.get("firstName"));
        elements.lastNameInput.setValue(testData.get("lastName"));
        chooseGender(testData.get("gender"));
        elements.mobileNumberInput.setValue(testData.get("phone"));

        testDataMap = new HashMap<>();
        testDataMap.put("Student Name", testData.get("firstName")+ " " + testData.get("lastName"));
        testDataMap.put("Gender", testData.get("gender"));
        testDataMap.put("Mobile", testData.get("phone"));
    }

    public void fillAllFields() {
        fillRequiredFields();
        System.out.println("Заполняются остальные поля");
        elements.emailInput.setValue(testData.get("email"));
        selectDay(
                Integer.parseInt(testData.get("birthDay")),
                Integer.parseInt(testData.get("birthMonth")),
                Integer.parseInt(testData.get("birthYear"))
        );
        elements.subjectsInput.setValue(testData.get("subject")).pressEnter();
        String hobby = chooseHobby(testData.get("hobby"));
        uploadPicture(testData.get("picturePath"));
        elements.currentAddressTextarea.setValue(testData.get("address"));
        selectDropdown(elements.stateDropdown, testData.get("state"));
        selectDropdown(elements.cityDropdown, testData.get("city"));

        testDataMap.put("Student Email", testData.get("email"));
        testDataMap.put("Date of Birth", testData.get("date"));
        testDataMap.put("Subjects", testData.get("subject"));
        testDataMap.put("Hobbies", hobby);
        testDataMap.put("Picture", testData.get("pictureName"));
        testDataMap.put("Address", testData.get("address"));
        testDataMap.put("State and City", testData.get("state") + " " + testData.get("city"));
    }

    public void submit() {
        System.out.println("Нажимается кнопка Submit");
        elements.submitButton.shouldBe(visible).shouldBe(enabled).scrollTo().click();
    }


    public boolean isSubmissionSuccessful() {
        return isSubmissionSuccessful(testDataMap);
    }

    public boolean isSubmissionSuccessful(Map<String, String> expectedData) {
        System.out.println("Проверка появления результирующей таблицы с данными");
        try {
            Thread.sleep(5000);
            // Selenide.Wait().until(Condition.visible(elements.resultTable));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!elements.resultTable.exists() || !elements.resultTable.isDisplayed()) {
            return false;
        }

        ElementsCollection rows = elements.resultTable.findAll("tr");

        for (Map.Entry<String, String> entry : expectedData.entrySet()) {
            String key = entry.getKey();
            String expectedValue = entry.getValue();

            System.out.println("key: " + key + " exp. value: " + expectedValue + "\n");

            boolean found = rows.stream().anyMatch(row -> {
                String rowText = row.getText();
                return rowText.contains(key) && rowText.contains(expectedValue);
            });


            if (!found) {
                System.out.println("Не найдена строка для: " + key + " со значением: " + expectedValue);
                return false;
            }
        }
        return true;
    }

    public void chooseGender(String gender){
        switch (gender){
            case "Male": elements.genderMaleRadio.click();
                break;
            case "Female": elements.genderFemaleRadio.click();
                break;
            default: elements.genderOtherRadio.click();
                break;
        }
        System.out.println("Выбран пол");
    }

    private void selectDay(int day, int month, int year) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String dayStr = String.format("%02d", day);
        String monthStr = months[month - 1];
        String dateStr = dayStr + " " + monthStr + " " + year;

        elements.dateOfBirthInput.click();
        executeJavaScript("document.querySelector('#dateOfBirthInput').value='" + dateStr + "'");

        String dayClass = String.format("div.react-datepicker__day--%03d", day);
        $(dayClass).click();
        System.out.println("Выбрана дата");
    }

    public String chooseHobby(String hobby){
        switch (hobby){
            case "Sports": elements.hobbiesSportsCheckbox.click();
                return hobby;
            case "Reading": elements.hobbiesReadingCheckbox.click();
                return hobby;
            case "Music": elements.hobbiesMusicCheckbox.click();
                return hobby;
            default: {
                elements.hobbiesSportsCheckbox.click();
                elements.hobbiesReadingCheckbox.click();
                elements.hobbiesMusicCheckbox.click();
                return "Reading, Sports, Music";
            }
        }
    }

    private void uploadPicture(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Файл не найден: " + filePath);
        }
        elements.pictureUploadButton.uploadFile(file);
        System.out.println("Загружен файл");
    }

    private void selectDropdown(SelenideElement dropdown, String value) {
        dropdown.shouldBe(visible).shouldBe(enabled).scrollTo().click();
        $x("//div[contains(@class,'menu')]//div[text()='" + value + "']")
                .shouldBe(visible)
                .click();
    }

    public String getFirstNameColour(){
       return elements.firstNameInput.getCssValue("border-color");
    }

    public String getLastNameColour(){
        return elements.lastNameInput.getCssValue("border-color");
    }

    public String getGenderColour(){
        return elements.genderMaleRadio.getCssValue("color");
    }

    public String getMobileColour(){
        return elements.mobileNumberInput.getCssValue("border-color");
    }

    public String getFirstNameBackgroundImage(){
        return elements.firstNameInput.getCssValue("background-image");
    }

    public String getLastNameBackgroundImage(){
        return elements.lastNameInput.getCssValue("background-image");
    }

    public String getMobileBackgroundImage(){
        return elements.mobileNumberInput.getCssValue("background-image");
    }

}
