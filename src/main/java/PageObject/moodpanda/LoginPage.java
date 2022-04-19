package PageObject.moodpanda;

import BaseObjects.SelenideBaseTest;
import Entinty.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends SelenideBaseTest {

    private SelenideElement emailInput = $("[type='text']");
    private SelenideElement passwordInput = $("[type='password']");
    private SelenideElement loginButton = $(byXpath("//*[contains(@class,'is-fullwidth is-oudtlined')]"));
    private SelenideElement invalidEmail = $(byXpath("//*[contains(@class,'is-danger is-small')]"));
    private SelenideElement invalidPassword = $(byXpath("(//*[contains(@class,'notification is-danger')])[2]"));
    private SelenideElement signUpButton = $(byXpath("(//*[@href='/signup'])[1]"));


    public LoginPage verificationLoginPage() {
        loginButton.shouldBe(exist).shouldBe(visible);
        emailInput.shouldHave(attribute("placeholder", "MoodPanda registered email "));
        return this;
    }

    public LoginPage sendEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage sendPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage authorization(User user) {
        sendEmail(user.getLogin()).sendPassword(user.getPassword()).clickOnLoginButton();
        return this;
    }

    public LoginPage verificationFailAuthorization() {
        invalidEmail.shouldHave(text("Invalid email address"));
        invalidPassword.shouldHave(text("One or more validation errors occurred."));
        return this;
    }

    public void switchToSignUpPage() {
        signUpButton.click();

    }


}
