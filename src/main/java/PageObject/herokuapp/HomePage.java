package PageObject.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends  BasePage {
    private By title=By.className("heading");

    public HomePage clickLink(HomeLinks link) {
        driver.findElement(By.partialLinkText(link.getLink())).click();
        return this;
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(),"Welcome to the-internet");
    }
}
