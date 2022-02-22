package Lecture_10.HomeWork;

import BaseObjects.BaseTest;
import PageObject.saucedemo.CardPage;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SolveWithDataProvider extends BaseTest {

    @Test(priority = 1, dataProvider = "authorization_tests")
    public void checkAuthorization(String username, String password) {
        driver.get(context.getSuite().getParameter("url"));
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization(username, password);
        get(ProductsPage.class).verifyPage();
    }

    @Test(priority = 2, dataProvider = "addItems_tests")
    public void addItems(int number) {
        get(ProductsPage.class).addItemInCard(number).verifyCountItems();
    }

    @Test(priority = 3, dataProvider = "removeItems_tests")
    public void removeItems(int number) {
        get(ProductsPage.class).clickOnCardItems();
        get(CardPage.class).verifyPage();
        get(CardPage.class).removeItem(number).verifyItemsAfterDelete();
    }


    List<String> validUserNames = new ArrayList() {{
        add("standard_user");
        add("problem_user");
        add("locked_out_user");
        add("performance_glitch_user");

    }};

    final String PASSWORD = "secret_sauce";

    @DataProvider(name = "addItems_tests")
    private Object[][] objects() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4}
        };
    }

    @DataProvider(name = "removeItems_tests")
    private Object[][] remove() {
        return new Object[][]{
                {1},
                {2},


        };
    }


    @DataProvider(name = "authorization_tests")
    private Object[][] getData() {
        return new Object[][]{
                {validUserNames.get(0), " "},
                {"sadadsadssda", "23123424"},
                {validUserNames.get(3), PASSWORD}


        };
    }

}
