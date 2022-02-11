package BaseObjects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static BaseObjects.DriverCreation.Drivers.CHROME;
import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

public class BaseTest {
    protected WebDriver driver;
    protected  ITestContext context;

    @BeforeTest
    public void preconditions(ITestContext context) {
        this.context=context;
        driver = getDriver(DriverCreation.Drivers.valueOf(context.getSuite().getParameter("browser")));
    }

    @AfterTest
    public void postconditions() {
        closeDriver();
    }


}
