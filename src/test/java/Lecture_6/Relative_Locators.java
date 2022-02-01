package Lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Relative_Locators {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRelativeLocators() {
        driver.get("https://www.saucedemo.com/");
        //WebElements
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement buttonLogin = driver.findElement(By.cssSelector(".submit-button.btn_action"));

        inputUsername.sendKeys("standard_user");
        inputPassword.sendKeys("secret_sauce");
        buttonLogin.click();

        WebElement description = driver.findElement(By.xpath("//*[@class='inventory_item'][2]//div[@class='inventory_item_desc']"));

        WebElement nameOfProduct = driver.findElement(with(By.tagName("div")).above(description));
        WebElement priceOfProduct = driver.findElement(with(By.tagName("div")).below(description));
        List<String> dataOnPage = new ArrayList<String>() {{
            add(nameOfProduct.getText());
            add(priceOfProduct.getText());
        }};
        System.out.println(dataOnPage);

        WebElement buttonAddToCard = driver.findElement(with(By.tagName("button")).toRightOf(priceOfProduct));
        WebElement productCard = driver.findElement(with(By.tagName("div")).above(By.className("product_sort_container")));


        buttonAddToCard.click();
        productCard.click();

        WebElement nameOfProductInCard = driver.findElement(with(By.tagName("div")).above(By.className("inventory_item_desc")));
        WebElement priceOfProductInCard = driver.findElement(By.cssSelector(".inventory_item_price"));

        List<String> dataInCard = new ArrayList<String>() {{
            add(nameOfProductInCard.getText());
            add(priceOfProductInCard.getText());
        }};

        Assert.assertEquals(dataOnPage, dataInCard);


    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
