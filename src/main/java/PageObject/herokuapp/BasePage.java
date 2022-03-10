package PageObject.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BaseObjects.DriverCreation.getDriver;

public  abstract  class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected  BasePage(){
        this.driver=getDriver();
        this.wait=new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.actions=new Actions(this.driver);
    }
    abstract public void verifyPage();

    protected BasePage openPage(String url) {
        driver.get(url);
        return this;
    }
}
