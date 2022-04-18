package Lecture_9;

import BaseObjects.BaseTest;
import PageObject.herokuapp.HomeLinks;
import PageObject.herokuapp.HomePage;
import PageObject.saucedemo.LoginPage;
import org.testng.annotations.Test;

public class Login_Page_Home extends BaseTest {
    @Test
    public  void ReturnOnLoginPage(String linkName){
        driver.get(context.getSuite().getParameter("url"));
        get(LoginPage.class).verifyPage();
    }
}

