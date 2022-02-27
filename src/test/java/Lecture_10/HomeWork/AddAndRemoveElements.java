package Lecture_10.HomeWork;

import BaseObjects.BaseTest;
import PageObject.saucedemo.CardPage;
import PageObject.saucedemo.ProductsPage;
import org.testng.annotations.Test;

public class AddAndRemoveElements extends BaseTest {
    int i = 0;

    @Test(priority = 1, invocationCount = 3)
    public void addElements() {
        get(ProductsPage.class).addItemInCard(i).verifyCountItems();
        i++;
    }

    @Test(priority = 2, invocationCount = 2)
    public void removeElements() {
        get(ProductsPage.class).clickOnCardItems();
        get(CardPage.class).verifyPage();
        get(CardPage.class).removeItem(1).verifyItemsAfterDelete();
    }
}
