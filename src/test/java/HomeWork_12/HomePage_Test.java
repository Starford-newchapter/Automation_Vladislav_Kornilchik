package HomeWork_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.HomeLinks;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    @Parameters({"linkName"})
    @Test
    public  void ReturnOnHomePage(String linkName){
        driver.get(context.getSuite().getParameter("url"));
        get(HomePage.class).verifyPage();
        get(HomePage.class).clickLink(HomeLinks.valueOf(linkName));
    }
}
