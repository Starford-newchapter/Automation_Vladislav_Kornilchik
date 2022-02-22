package PageObject.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CardPage extends BasePage {

    private By title = By.className("title");

    private By removeButton(int number) {
        return By.xpath("(//*[@class='item_pricebar']/button)[" + number + "]");
    }

    private By checkoutButton = By.id("checkout");
    private By removedItem = By.className("removed_cart_item");
    private By backToShoppingButton = By.id("continue-shopping");


    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());

    }

    public CardPage verifyItemsAfterDelete() {
        Assert.assertTrue(driver.findElement(removedItem).isEnabled());
        return this;

    }

    public CardPage clickOnContinueShopping() {
        driver.findElement(backToShoppingButton).click();
        return this;
    }

    public CardPage removeItem(int number) {
        driver.findElement(removeButton(number)).click();
        return this;
    }

    public CardPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return this;
    }

    public CardPage(WebDriver driver) {
        super(driver);
    }
}
