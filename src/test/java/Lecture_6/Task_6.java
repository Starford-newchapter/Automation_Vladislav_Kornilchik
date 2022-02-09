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

public class Task_6 {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSauceDemo_MainLocators() {
        driver.get("https://www.saucedemo.com/");
        //WebElements
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement buttonLogin = driver.findElement(By.cssSelector(".submit-button.btn_action"));

        inputUsername.sendKeys("standard_user");
        inputPassword.sendKeys("secret_sauce");
        buttonLogin.click();

        String nameOfProduct = driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]//following::div[3]")).getText();
        String nameOfProduct2=driver.findElement(By.xpath("//div[@class='inventory_item_img']/following::*[text()='Sauce Labs Backpack']")).getText();
        String priceOfProduct = driver.findElement(By.cssSelector("[class$=price]")).getText();;
        WebElement buttonAddToCard = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory' and @name='add-to-cart-sauce-labs-backpack']"));
        buttonAddToCard.click();
        WebElement productCard = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']/ancestor::a"));
        List<String> dataOnPage = new ArrayList<String>() {{
            add(nameOfProduct2);
            add(priceOfProduct);
        }};
        productCard.click();

        WebElement nameOfProductInCard = driver.findElement(By.partialLinkText("Sauce"));
        WebElement priceOfProductInCard = driver.findElement(By.cssSelector("[class^=inventory_item_p]"));

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
