package BaseObjects;

import Properties.PropertyReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public abstract class SelenideBaseTest {
    private ITestContext context;
    private PropertyReader propertyReader;

    @BeforeTest
    public void setUp(ITestContext context) {
        this.context = context;
        this.propertyReader = new PropertyReader(context.getSuite().getParameter("config"));
    }

    protected <T> T get(Class<T> pageClass) {
        return driver().hasWebDriverStarted() ? page(pageClass) : open(PropertyReader.getProperties().getProperty("url"), pageClass);
    }
}



