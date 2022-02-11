package Lecture_6;

import BaseObjects.BaseTest;
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

public class Task_6 extends BaseTest {


    @Test
    public void testSauceDemo_MainLocators() {
        driver.get(context.getSuite().getParameter("url"));
        //WebElements
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement buttonLogin = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        inputUsername.sendKeys("standard_user");
        inputPassword.sendKeys("secret_sauce");
        buttonLogin.click();
        String nameOfProduct = driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]//following::div[3]")).getText();
        WebElement priceOfProduct = driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]//div[2]//div[@class='inventory_item_price']"));
        WebElement buttonAddToCard = driver.findElement(with(By.tagName("button")).toRightOf(priceOfProduct));
        WebElement productCard = driver.findElement(By.className("shopping_cart_container"));
        List<String> dataOnPage = new ArrayList<String>() {{
            add(nameOfProduct);
            add(priceOfProduct.getText());
        }};
        buttonAddToCard.click();
        productCard.click();
        WebElement nameOfProductInCard = driver.findElement(By.className("inventory_item_name"));
        WebElement priceOfProductInCard = driver.findElement(By.cssSelector(".inventory_item_price"));
        List<String> dataInCard = new ArrayList<String>() {{
            add(nameOfProductInCard.getText());
            add(priceOfProductInCard.getText());
        }};
        Assert.assertEquals(dataOnPage, dataInCard);


    }


}
