package PageObject.herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ContextMenuPage extends  BasePage {
    private By title=By.tagName("h3");
    private  By areaForRightClick=By.id("hot-spot");

    public ContextMenuPage RightClick(){
        actions.contextClick(driver.findElement(areaForRightClick)).perform();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"You selected a context menu");
        alert.accept();
        return  this;
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(),"Context Menu");
    }
}
