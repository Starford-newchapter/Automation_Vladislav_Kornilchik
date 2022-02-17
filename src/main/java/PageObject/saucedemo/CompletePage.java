package PageObject.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompletePage extends BasePage {

    private By completeHeader = By.className("complete-header");
    private By completeImage = By.tagName("img");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(completeHeader).getText(), "THANK YOU FOR YOUR ORDER");
        Assert.assertTrue(driver.findElement(completeImage).isDisplayed());

    }
}
