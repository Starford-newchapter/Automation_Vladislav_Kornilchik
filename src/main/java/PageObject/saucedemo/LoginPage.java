package PageObject.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By inputLogin = By.name("user-name");
    private By inputPassword = By.id("password");
    private By loginButton = By.name("login-button");
    private  By loginLogo=By.className("login_logo");

    public void clickLoginButton() {
        driver.findElement(loginButton).click();

    }

    public void sendUserName(String username) {
        driver.findElement(inputLogin).sendKeys(username);
    }

    public void sendPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void authorization(String username, String password) {
        sendUserName(username);
        sendPassword(password);
        clickLoginButton();

    }


    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(loginLogo).isDisplayed());
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
