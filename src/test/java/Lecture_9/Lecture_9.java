package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.saucedemo.*;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {


    @Test(priority = 1)
    public void addItemInCard() {
        get(ProductsPage.class).verifyPage();
        get(ProductsPage.class).addItemInCard().verifyCountItems().clickOnCardItems();


    }


    @Test(priority = 2)
    public void removeItemsFromCard() {
        get(CardPage.class).verifyPage();
        get(CardPage.class).removeItem().verifyItemsAfterDelete().clickCheckout();

    }

    @Test(priority = 3)
    public void checkOutOrder() {
        get(CheckoutPage.class).verifyPage();
        get(CheckoutPage.class).sendInformation("Vladislav", "Vladislav", "12345");
    }

    @Test(priority = 4)
    public void confirmOrder() {
        get(ConfirmPage.class).verifyPage();
        get(ConfirmPage.class).clickFinishButton();

    }

    @Test(priority = 5)
    public void completeInformation() {
        get(CompletePage.class).verifyPage();
    }
}









