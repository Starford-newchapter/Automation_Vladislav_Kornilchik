package Lecture_10.HomeWork;

import BaseObjects.BaseTest;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Authorization extends BaseTest {
    @BeforeMethod
    public void preconditions() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test(priority = 4)
    public void successAuthorization() {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization("standard_user", "secret_sauce");
        get(ProductsPage.class).verifyPage();
    }


    @Test(priority = 1)
    public void authorizationWithEmptyPassword() {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization("standard_user", " ");
        get(ProductsPage.class).verifyPage();

    }

    @Test(priority = 2)
    public void authorizationWithWrongPassword() {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization("standard_user", "sadasdasd");
        get(ProductsPage.class).verifyPage();


    }

    @Test(priority = 3)
    public void authorizationWithWrongUserName() {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization("qwerts", "secret_sauced");
        get(ProductsPage.class).verifyPage();


    }
}
