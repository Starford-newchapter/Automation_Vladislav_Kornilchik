package HomeWork_13;

import BaseObjects.BaseTest;
import PageObject.herokuapp.iFramePage;
import org.testng.annotations.Test;

public class iFrames extends BaseTest {
    @Test
    public void iFrameTest() {
        get(iFramePage.class).redirectOnIframePage();
        get(iFramePage.class).verifyPage();
        get(iFramePage.class).checkTextOnIframe();
    }
}
