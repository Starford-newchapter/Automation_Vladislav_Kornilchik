package PageObject.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;

public class FileUploadPage extends BasePage {
    private By title = By.tagName("h3");
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By nameFile = By.id("uploaded-files");
    private String pathToFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "UploadFiles" + File.separator;
    private String fileName = "lex.jpg";

    public FileUploadPage chooseFile() {
        driver.findElement(chooseFileButton).sendKeys(pathToFile + fileName);
        return this;
    }

    public FileUploadPage verificationUpload() {
        Assert.assertEquals(driver.findElement(title).getText(), "File Uploaded!");
        Assert.assertEquals(driver.findElement(nameFile).getText(), fileName);
        return this;
    }

    public FileUploadPage uploadFile() {
        chooseFile();
        js.executeScript("arguments[0].click();",driver.findElement(uploadButton));
        verificationUpload();
        return this;
    }

    @Override
    public void verifyPage() {
        Assert.assertEquals(driver.findElement(title).getText(), "File Uploader");
    }
}
