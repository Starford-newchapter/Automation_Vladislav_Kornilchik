package PageObject.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    private By buttonAddToCard = By.id("add-to-cart-sauce-labs-bike-light");
    private By cardItems = By.className("shopping_cart_link");
    private By countItemsInCard = By.className("shopping_cart_badge");
    private By title = By.className("title");

    public ProductsPage addItemInCard() {
        driver.findElement(buttonAddToCard).click();
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

