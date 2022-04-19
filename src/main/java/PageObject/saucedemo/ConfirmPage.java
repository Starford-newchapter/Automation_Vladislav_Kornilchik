package PageObject.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmPage extends BasePage {
    private By title = By.className("title");
    private By finishButton = By.id("finish");


    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());

    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}