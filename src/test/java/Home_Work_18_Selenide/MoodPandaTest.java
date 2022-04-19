package Home_Work_18_Selenide;

import BaseObjects.SelenideBaseTest;
import Entinty.User;
import PageObject.moodpanda.LoginPage;
import PageObject.moodpanda.MainPage;
import PageObject.moodpanda.SignUpPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class MoodPandaTest extends SelenideBaseTest {

    @Test(priority = 1)
    @Description("Switch on LoginPage")
    public void getStarted() {
        get(MainPage.class).verificationMainPage().clickOnGetStarted();
    }

    @Test(priority = 2)
    public void failAuthorization() {
        get(LoginPage.class).verificationLoginPage().authorization(new User.Builder().withLogin("qwerty").withPassword("12345").build());
        get(LoginPage.class).verificationFailAuthorization();
        get(LoginPage.class).switchToSignUpPage();
    }

    @Test(priority = 3)
    public void failSignUp() {
        get(SignUpPage.class).signUp("Vladislav", "2", "3", "qwerty12345").confirmEmail().ErrorsFailSignUp();
    }
}
