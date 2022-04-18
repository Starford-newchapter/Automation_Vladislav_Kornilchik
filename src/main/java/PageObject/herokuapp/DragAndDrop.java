package PageObject.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;

public class DragAndDrop extends  BasePage{
    private By title=By.tagName("h3");
    private  By area_A=By.id("column-a");
    private  By area_B=By.id("column-b");
    private  By header_A=By.xpath("//*[@id='column-a']//header");
    private  By header_B=By.xpath("//*[@id='column-b']//header");

    public DragAndDrop  dragAndDrop(){
        actions.dragAndDrop(driver.findElement(area_A),driver.findElement(area_B)).perform();
        System.out.println(driver.findElement(header_A).getText());
        System.out.println(driver.findElement(header_B).getText());
        return this;
    }


    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(),"Drag and Drop");

    }
}
