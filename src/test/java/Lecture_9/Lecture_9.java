package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.saucedemo.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {


    @Test(priority = 1, description = "Product Page")
    @Description("Сhecking the possibility of adding items")
    @Step("Add item")
    @Attachment(value = "ProductPage", type = "src/test/ProductPage.jpg")
    public void addItemInCard() {
        get(ProductsPage.class).addItemInCard().verifyCountItems().clickOnCardItems();
        get(CardPage.class).verifyPage();

    }


    @Test(priority = 2, description = "Card Page")
    @Description("Сhecking the possibility of removing items")
    @Step("Remove item")
    @Attachment(value ="CardPage_2",type = "src/test/CardPage.jpg")

    public void removeItemsFromCard() {
        get(CardPage.class).removeItem().verifyItemsAfterDelete().clickCheckout();
        get(CheckoutPage.class).verifyPage();

    }

    @Test(priority = 3, description = "CheckOut Page")
    @Description("Filling  the data for delivery ")
    @Step("Filling the data")
    @Attachment(value = "CheckOutPage", type = "src/test/checkoutPage.jpg")
    public void checkOutOrder() {
        get(CheckoutPage.class).sendInformation("Vladislav", "Vladislav", "12345");
        get(ConfirmPage.class).verifyPage();
    }

    @Test(priority = 4,description = "Confirm Order Page")
    @Description("Confirm order ")
    @Step("Confirm order")
    @Attachment(value = "ConfirmPage", type = "src/test/ConfirmPage.jpg")

    public void confirmOrder() {
        get(ConfirmPage.class).clickFinishButton();

    }

    @Test(priority = 5)

    public void completeInformation() {
        get(CompletePage.class).verifyPage();
    }
}









