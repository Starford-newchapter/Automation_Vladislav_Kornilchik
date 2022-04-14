package PageFactory.saucedemo;

import Entinty.User;
import PageObject.herokuapp.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(css = ".bot_column")
        private WebElement logo;

    @FindBy(id = "user-name")
    private  WebElement loginInput;

    @FindBy(id ="password")
    private  WebElement passwordInput;

    @FindBy(id ="login-button")
    private WebElement buttonLogin;

    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;

    public LoginPage sendLogin(String login){
        loginInput.sendKeys(login);
        return  this;
    }
    public  LoginPage sendPassword(String password){
        passwordInput.sendKeys(password);
        return  this;
    }

    public LoginPage clickLoginButton(){
        buttonLogin.click();
        return  this;
    }

    public LoginPage() {
        PageFactory.initElements(super.driver, this);
    }

    public void authorization(User user) {
        sendLogin(user.getLogin()).sendPassword(user.getPassword()).clickLoginButton();
    }

    public String getExceptionTxt() {
        return errorMessage.getText();
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(logo.isDisplayed());

    }
}
