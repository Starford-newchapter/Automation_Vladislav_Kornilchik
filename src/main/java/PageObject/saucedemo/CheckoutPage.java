package PageObject.saucedemo;

import Entinty.CheckOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    private By title = By.className("title");
    private By continueButton = By.id("continue");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By zipCodeInput = By.id("postal-code");


    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());

    }

    public CheckoutPage sendFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public CheckoutPage sendLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public CheckoutPage sendZipCode(String zipCode) {
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        return this;
    }

    public CheckoutPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

    public void sendInformation(CheckOut checkOut) {
        sendFirstName(checkOut.getFirstName()).sendLastName(checkOut.getLastName()).sendZipCode(checkOut.getZipCode()).clickContinueButton();
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}