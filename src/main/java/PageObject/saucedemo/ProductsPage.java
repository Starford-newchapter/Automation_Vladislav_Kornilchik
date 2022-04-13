package PageObject.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {

    By addButton = By.xpath("//*[@class='pricebar']//button");

    List<WebElement> list = driver.findElements(addButton);

    private By cardItems = By.className("shopping_cart_link");
    private By countItemsInCard = By.className("shopping_cart_badge");
    private By title = By.className("title");

    public ProductsPage addItemInCard(int n) {
        list.get(n).click();
        return this;
    }

    public ProductsPage clickOnCardItems() {
        driver.findElement(cardItems).click();

        return this;
    }

    public ProductsPage verifyCountItems() {
        Assert.assertTrue((driver.findElement(countItemsInCard).isDisplayed()));
        return this;

    }


    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());

    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


}