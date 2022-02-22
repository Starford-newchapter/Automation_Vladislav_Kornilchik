package BaseObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Locale;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class DriverCreation {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(String drivers) {
        if (driver.get() == null) {
            driver.set(getInstance(DriverManagerType.valueOf(drivers.toUpperCase(Locale.ROOT))).create());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver(String drivers) {
        getInstance(DriverManagerType.valueOf(drivers.toUpperCase(Locale.ROOT))).quit();
    }
}

