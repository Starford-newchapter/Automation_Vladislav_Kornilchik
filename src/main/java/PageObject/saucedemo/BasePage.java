package PageObject.saucedemo;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    abstract public void verifyPage();

    public BasePage(WebDriver driver) {
        this.driver = driver;


    }
}
