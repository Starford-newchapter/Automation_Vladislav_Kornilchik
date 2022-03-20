package HomeWork_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.FileUploadPage;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    @Test
    public void test() {
        get(FileUploadPage.class).verifyPage();
        get(FileUploadPage.class).uploadFile();
    }
}