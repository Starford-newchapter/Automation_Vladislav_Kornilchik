package TestNgUtills;

import BaseObjects.DriverCreation;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import  static  BaseObjects.DriverCreation.getDriver;

public class InvokedMethodsListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(!testResult.isSuccess() && getDriver()!=null) {
            byte[] screen = ((TakesScreenshot) DriverCreation.getDriver()).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screen);
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] bytes) {
        return bytes;
    }

}
