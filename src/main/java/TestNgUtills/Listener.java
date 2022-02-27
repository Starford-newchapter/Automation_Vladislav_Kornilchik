package TestNgUtills;

import BaseObjects.DriverCreation;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        byte[] screen=((TakesScreenshot) DriverCreation.getDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(screen);

    }

    @Attachment(value = "Screenshot",type="image/png")
    private byte[] saveScreenshot(byte[] bytes){
        return  bytes;
    }
}
