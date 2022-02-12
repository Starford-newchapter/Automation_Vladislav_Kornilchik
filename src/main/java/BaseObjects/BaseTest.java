package BaseObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.InvocationTargetException;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;
    private String browserName;

    @BeforeTest
    public void preconditions(ITestContext context) {
        this.context = context;
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        this.driver = getDriver(browserName == null ? "CHROME" : browserName);
    }

    protected <T> T get(Class<T> page) {
        return get(page,this.driver);
    }

    protected <T> T get(Class<T> page, WebDriver driver) {
        T instance = null;
        try {
            instance = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchElementException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

     @AfterTest
    public void postconditions() {
         closeDriver(browserName == null ? "CHROME" : browserName);


    }






}



