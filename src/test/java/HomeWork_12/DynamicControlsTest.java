package HomeWork_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.DynamicControlsPage;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test(priority = 1)
    public  void RemoveCheckBox(){
        get(DynamicControlsPage.class).verifyPage();
        get(DynamicControlsPage.class).removeAddStage();
    }

    @Test(priority = 2)
    public  void EnableInputArea(){
        get(DynamicControlsPage.class).enableDisableStage();
    }
}
