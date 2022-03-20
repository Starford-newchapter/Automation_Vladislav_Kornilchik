package HomeWork_13;

import BaseObjects.BaseTest;
import PageObject.herokuapp.JavaScriptAlertsPage;
import org.testng.annotations.Test;

public class JavaScriptAlertTest extends BaseTest {
    @Test
    public  void JsAlertPageTest(){
        get(JavaScriptAlertsPage.class).verifyPage();
        get(JavaScriptAlertsPage.class).clickOnJsAlert().clickOnJsConfirm().clickOnJsPrompt();
    }
}
