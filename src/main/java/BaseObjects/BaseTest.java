package BaseObjects;

import TestNgUtills.InvokedMethodsListener;
import TestNgUtills.Listener;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;

import static BaseObjects.DriverCreation.*;

@Listeners({Listener.class, InvokedMethodsListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;
    private String browserName;

    @BeforeTest
    public void preconditions(ITestContext context) {
        this.context = context;
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        createDriver(browserName == null ? "chrome" : browserName);
        this.driver = getDriver();
    }

    protected <T> T get(Class<T> page) {
        return get(page, this.driver);
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



