package PageObject.saucedemo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;

    abstract public void verifyPage();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
