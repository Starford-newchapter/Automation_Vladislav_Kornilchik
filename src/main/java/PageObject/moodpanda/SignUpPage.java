package PageObject.moodpanda;

import BaseObjects.SelenideBaseTest;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage extends SelenideBaseTest {

    private SelenideElement firstNameInput = $(byXpath("(//*[@type='text'])[1]"));
    private SelenideElement lastNameInput = $(byXpath("(//*[@type='text'])[2]"));
    private SelenideElement emailInput = $(byXpath("(//*[@type='text'])[3]"));
    private SelenideElement passwordInput = $("[type='password']");
    private SelenideElement signUpButton = $(byXpath("//*[contains(@class,'is-pulledd-right')]"));
    private SelenideElement checkbox = $(byXpath("//*[@type='checkbox']"));
    private SelenideElement confirmEmailButton = $(byXpath("//span[contains(.,'Yes. Sign me up')]"));
    private SelenideElement invalidEmail = $(byXpath("//*[contains(@class,'is-danger is-small')]"));
    private SelenideElement validationErrors = $(byXpath("(//*[contains(@class,'notification is-danger')])[2]"));

    public SignUpPage getFirstNameText() {
        System.out.println(firstNameInput.getAttribute("placeholder"));
        return this;
    }

    public SignUpPage sendFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public SignUpPage sendLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public SignUpPage sendEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public SignUpPage sendPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public SignUpPage clickOnCheckBox() {
        checkbox.click();
        return this;
    }

    public SignUpPage clickOnSignUpButton() {
        signUpButton.click();
        return this;
    }

    public SignUpPage signUp(String firstName, String lastName, String email, String password) {
        sendFirstName(firstName).sendLastName(lastName).sendEmail(email).sendPassword(password).clickOnCheckBox().clickOnSignUpButton();
        return this;
    }

    public SignUpPage confirmEmail() {
        confirmEmailButton.click();
        return this;
    }

    public SignUpPage ErrorsFailSignUp() {
        invalidEmail.shouldHave(text("Invalid email address"));
        validationErrors.shouldHave(text("One or more validation errors occurred."));
        return this;
    }
}
