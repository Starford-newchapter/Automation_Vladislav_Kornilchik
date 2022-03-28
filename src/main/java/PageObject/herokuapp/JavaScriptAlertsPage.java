package PageObject.herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {
    private By title = By.tagName("h3");
    private By buttonJsAlert = By.xpath("(//li//button)[1]");
    private By buttonJsConfirm = By.xpath("(//li//button)[2]");
    private By buttonJsPrompt = By.xpath("(//li//button)[3]");
    private By result = By.id("result");
    private Alert alert;
    private String textOnJsPrompt = "Hello prompt";

    private JavaScriptAlertsPage verifyResult(String text) {
        String resultText = js.executeScript("return arguments[0].innerHTML;", driver.findElement(result)).toString();
        Assert.assertEquals(resultText, text);
        return this;
    }

    private Alert verifyAlertText(String text) {
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), text);
        return alert;
    }

    public JavaScriptAlertsPage clickOnJsAlert() {
        driver.findElement(buttonJsAlert).click();
        verifyAlertText("I am a JS Alert").accept();
        verifyResult("You successfully clicked an alert");
        return this;
    }

    public JavaScriptAlertsPage clickOnJsConfirm() {
        driver.findElement(buttonJsConfirm).click();
        verifyAlertText("I am a JS Confirm").dismiss();
        verifyResult("You clicked: Cancel");
        return this;
    }

    public JavaScriptAlertsPage clickOnJsPrompt() {
        driver.findElement(buttonJsPrompt).click();
        verifyAlertText("I am a JS prompt").sendKeys(textOnJsPrompt);
        alert.accept();
        verifyResult("You entered: " + textOnJsPrompt);
        return this;
    }

    @Override
    public void verifyPage() {
        String verifyText = js.executeScript("return arguments[0].innerHTML;", driver.findElement(title)).toString();
        Assert.assertEquals(verifyText, "JavaScript Alerts");
    }
}
