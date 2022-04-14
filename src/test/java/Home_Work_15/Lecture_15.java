package Home_Work_15;
import BaseObjects.BaseTest;
import Entinty.CheckOut;
import Entinty.User;
import PageFactory.saucedemo.LoginPage;
import PageObject.saucedemo.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lecture_15 extends BaseTest {
    @BeforeTest
    public void precondition() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test(priority = 1, dataProvider = "authorization_tests")
    public void authorization(User user) {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization(user);
    }

    @Test(priority = 2)
    public void addItemInCard() {
        get(ProductsPage.class).addItemInCard(2).verifyCountItems().clickOnCardItems();
        get(CardPage.class).verifyPage();
    }

    @Test(priority = 3)
    public void CardPageContinue() {
        get(CardPage.class).clickCheckout();
        get(CheckoutPage.class).verifyPage();
    }

    @Test(priority = 4)
    public void checkOutOrder() {
        CheckOut checkOut = new CheckOut();
        checkOut.setFirstName("Vladislav");
        checkOut.setLastName("Ivanov");
        checkOut.setZipCode("22134");
        get(CheckoutPage.class).sendInformation(checkOut);
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


    @DataProvider(name = "authorization_tests")
    private Object[][] getData() {
        return new Object[][]{
                {new User(" ", "12345")},
                {new User.Builder().withLogin("wqeqweqe").withPassword(" ").build()},
                {new User.Builder().withLogin("standard_user").withPassword("secret_sauce").build()}
        };
    }

}
