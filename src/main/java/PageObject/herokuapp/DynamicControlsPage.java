package PageObject.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {
    private By title = By.tagName("h4");
    private By checkbox = By.id("checkbox");
    private By buttonRemoveOrAddCheckbox = By.xpath("(//*[@type='button'])[1]");
    private By inputText = By.xpath("//*[@type='text']");
    private By buttonEnableOrDisableInput = By.xpath("(//*[@type='button'])[2]");
    private By messageItsGone = By.xpath("//*[@id='checkbox-example']/p[@id='message']");
    private By messageItsEnable = By.xpath("//*[@id='input-example']/p[@id='message']");

    public DynamicControlsPage clickOnRemoveButton() {
        driver.findElement(buttonRemoveOrAddCheckbox).click();
        return this;
    }

    public DynamicControlsPage clickOnEnableButton() {
        driver.findElement(buttonEnableOrDisableInput).click();
        return this;
    }

    public DynamicControlsPage checkMessageCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageItsGone));
        Assert.assertEquals(driver.findElement(messageItsGone).getText(),"It's gone!");
        return this;
    }

    public DynamicControlsPage checkMessageEnabled() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageItsEnable));
        Assert.assertEquals(driver.findElement(messageItsEnable).getText(),"It's enabled!");
        return this;
    }

    public DynamicControlsPage removeAddStage() {
        Assert.assertTrue(driver.findElement(checkbox).isDisplayed());
        clickOnRemoveButton().checkMessageCheckBox();
        Assert.assertEquals(driver.findElements(checkbox).size(),0);
        return this;
    }

    public DynamicControlsPage enableDisableStage() {
        Assert.assertFalse(driver.findElement(inputText).isEnabled(),"Поле для ввода доступно");
        clickOnEnableButton().checkMessageEnabled();
        Assert.assertTrue(driver.findElement(inputText).isEnabled(),"Поле для ввода задизэйблино");
        return this;
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(), "Dynamic Controls");
    }
}
