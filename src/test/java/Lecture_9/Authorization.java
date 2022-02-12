package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Authorization extends BaseTest {



    @BeforeMethod
    public void precondition() {
        driver.get(context.getSuite().getParameter("url"));
    }


    @Test(dataProvider = "authorization_tests")
    public void checkAuthorization(String username, String password) {
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization(username,password);
            }




    List<String> validUserNames = new ArrayList() {{
        add("standard_user");
        add("problem_user");
        add("locked_out_user");
        add("performance_glitch_user");

    }};

    final String PASSWORD = "secret_sauce";

    @DataProvider(name = "authorization_tests")
    private Object[][] getData() {
        return new Object[][]{
                {validUserNames.get(0), PASSWORD},
                {validUserNames.get(1), PASSWORD},
                {validUserNames.get(2), PASSWORD},
                {validUserNames.get(3),PASSWORD}


        };
    }

}

