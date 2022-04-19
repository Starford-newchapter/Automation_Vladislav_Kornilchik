package Home_Work_16_Lombok;

import BaseObjects.BaseTest;
import Entinty.CheckOut;
import Entinty.User;
import PageFactory.saucedemo.LoginPage;
import PageObject.saucedemo.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_16 extends BaseTest {
    @BeforeTest
    public void precondition() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test(priority = 1)
    public void authorization() {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization(new User.Builder().withLogin("standard_user").withPassword("secret_sauce").build());
    }

    @Test(priority = 2)
    public void addItemInCard() {
        get(ProductsPage.class).addItemInCard(1).verifyCountItems().clickOnCardItems();
        get(CardPage.class).verifyPage();
    }

    @Test(priority = 3)
    public void CardPageContinue() {
        get(CardPage.class).clickCheckout();
        get(CheckoutPage.class).verifyPage();
    }

    @Test(priority = 4)
    public void checkOutOrder() {
        get(CheckoutPage.class).sendInformation(new CheckOut.CheckoutBuilder().withFirstName("Vladislav").withLastName("Ivanov").withZipCode("123345").create());
        get(ConfirmPage.class).verifyPage();
    }

    @Test(priority = 5)
    public void confirmOrder() {
        get(ConfirmPage.class).clickFinishButton();
    }

    @Test(priority = 6)
    public void completeInformation() {
        get(CompletePage.class).verifyPage();
    }

}

