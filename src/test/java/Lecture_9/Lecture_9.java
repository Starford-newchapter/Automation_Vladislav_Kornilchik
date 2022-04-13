package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.saucedemo.*;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {


    @Test(priority = 1)
    public void addItemInCard() {
        get(ProductsPage.class).addItemInCard(2).verifyCountItems().clickOnCardItems();
        get(CardPage.class).verifyPage();
    }

    @Test(priority = 2)
    public void removeItemsFromCard() {
        get(CardPage.class).removeItem(1).verifyItemsAfterDelete().clickCheckout();
        get(CheckoutPage.class).verifyPage();
    }

    @Test(priority = 3)
    public void checkOutOrder() {
        get(CheckoutPage.class).sendInformation("Vladislav", "Vladislav", "12345");
        get(ConfirmPage.class).verifyPage();
    }

    @Test(priority = 4)
    public void confirmOrder() {
        get(ConfirmPage.class).clickFinishButton();
    }

    @Test(priority = 5)
    public void completeInformation() {
        get(CompletePage.class).verifyPage();
    }
}











