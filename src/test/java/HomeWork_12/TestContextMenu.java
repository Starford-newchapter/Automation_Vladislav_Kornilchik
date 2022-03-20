package HomeWork_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.ContextMenuPage;
import org.testng.annotations.Test;

public class TestContextMenu extends BaseTest {
    @Test(description = "Right Click and validate text on alert")
    public  void ContextMenuTest(){
        get(ContextMenuPage.class).verifyPage();
        get(ContextMenuPage.class).RightClick();
    }
}
