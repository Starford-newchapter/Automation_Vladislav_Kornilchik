package Lecture_10.HomeWork;

import BaseObjects.BaseTest;
import PageObject.saucedemo.CardPage;
import PageObject.saucedemo.ProductsPage;
import io.qameta.allure.Attachment;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AddAndRemoveElements extends BaseTest {
    int i = 0;

    @Test(priority = 1, invocationCount = 3)
    @Description("Add elements in card")
    public void addElements() {
        get(ProductsPage.class).addItemInCard(2);
        i++;
    }

    @Test(priority = 2, invocationCount = 3)
    public void removeElements() {
        get(ProductsPage.class).clickOnCardItems();
        get(CardPage.class).verifyPage();
        get(CardPage.class).removeItem(1).verifyItemsAfterDelete();
    }
}
