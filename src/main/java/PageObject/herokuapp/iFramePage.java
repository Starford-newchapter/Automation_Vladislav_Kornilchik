package PageObject.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;

public class iFramePage extends BasePage {
    private By iFrameLink = By.xpath("//*[@href='/iframe']");
    private By title = By.tagName("h3");
    private By iFrame = By.id("mce_0_ifr");
    private By textAreaIniFrame = By.id("tinymce");

    public iFramePage redirectOnIframePage() {
        driver.findElement(iFrameLink).click();
        return this;
    }

    public iFramePage checkTextOnIframe() {
        driver.switchTo().frame(driver.findElement(iFrame));
        Assert.assertEquals(driver.findElement(textAreaIniFrame).getText(), "Your content goes here.");
        return this;
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}
