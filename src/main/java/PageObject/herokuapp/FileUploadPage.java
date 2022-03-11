package PageObject.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;

public class FileUploadPage extends BasePage {
    private By title = By.tagName("h3");
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By nameFile = By.id("uploaded-files");

    public FileUploadPage chooseFile() {
        driver.findElement(chooseFileButton).sendKeys("C:\\Users\\ua.karnilchyk\\Downloads\\fail_output.jpg");
        return this;
    }

    public FileUploadPage verificationUpload() {
        Assert.assertEquals(driver.findElement(title).getText(), "File Uploaded!");
        Assert.assertEquals(driver.findElement(nameFile).getText(), "fail_output.jpg");
        return this;
    }

    public FileUploadPage uploadFile() {
        chooseFile();
        driver.findElement(uploadButton).click();
        verificationUpload();
        return this;
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(), "File Uploader");
    }
}
