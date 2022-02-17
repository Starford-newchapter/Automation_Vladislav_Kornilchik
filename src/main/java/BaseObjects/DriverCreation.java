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
    private static WebDriver driver;


    public static WebDriver getDriver(String drivers) {
        if (driver == null) {
            driver = getInstance(DriverManagerType.valueOf(drivers.toUpperCase(Locale.ROOT))).create();
            driver.manage().window().maximize();

        }
        return driver;
    }

    public static void closeDriver(String drivers) {
        getInstance(DriverManagerType.valueOf(drivers.toUpperCase(Locale.ROOT))).quit();
    }


}

