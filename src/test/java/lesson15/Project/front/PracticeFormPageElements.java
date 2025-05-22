package lesson15.Project.front;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPageElements {
    public SelenideElement firstNameInput = $x("//input[@id='firstName']");
    public SelenideElement lastNameInput = $x("//input[@id='lastName']");
    public SelenideElement emailInput = $x("//input[@id='userEmail']");
    public SelenideElement genderMaleRadio = $x("//label[@for='gender-radio-1']");
    public SelenideElement genderFemaleRadio = $x("//label[@for='gender-radio-2']");
    public SelenideElement genderOtherRadio = $x("//label[@for='gender-radio-3']");
    public SelenideElement mobileNumberInput = $x("//input[@id='userNumber']");
    public SelenideElement dateOfBirthInput = $x("//input[@id='dateOfBirthInput']");
    public SelenideElement subjectsInput = $x("//input[@id='subjectsInput']");
    public SelenideElement hobbiesSportsCheckbox = $x("//label[@for='hobbies-checkbox-1']");
    public SelenideElement hobbiesReadingCheckbox = $x("//label[@for='hobbies-checkbox-2']");
    public SelenideElement hobbiesMusicCheckbox = $x("//label[@for='hobbies-checkbox-3']");
    public SelenideElement pictureUploadButton = $x("//input[@id='uploadPicture']");
    public SelenideElement currentAddressTextarea = $x("//textarea[@id='currentAddress']");
    public SelenideElement stateDropdown = $x("//div[@id='state']");
    public SelenideElement cityDropdown = $x("//div[@id='city']");
    public SelenideElement submitButton = $x("//button[@id='submit']");

    public SelenideElement resultTable = $x("//div[contains(@class,'modal-content')]");
}