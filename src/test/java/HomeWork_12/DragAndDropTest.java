package HomeWork_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.DragAndDrop;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {
    @Test
    public  void dragAndDrop(){
        get(DragAndDrop.class).verifyPage();
        get(DragAndDrop.class).dragAndDrop();
    }
}
