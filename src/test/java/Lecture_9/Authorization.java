package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductsPage;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Authorization extends BaseTest {

    @Test(dataProvider = "authorization_tests", description = "LoginPage")
    @Step("Authorization")

    public void checkAuthorization(String username, String password) {
        driver.get(context.getSuite().getParameter("url"));
        get(LoginPage.class).verifyPage();
        get(LoginPage.class).authorization(username, password);
        get(ProductsPage.class).verifyPage();
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
                {validUserNames.get(0), " "},
                {"sadadsadssda", "23123424"},
                {validUserNames.get(3), PASSWORD}


        };
    }

}


