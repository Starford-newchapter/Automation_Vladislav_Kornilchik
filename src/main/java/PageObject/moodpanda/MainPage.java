package PageObject.moodpanda;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SelenideElement.*;

public class MainPage {

    private SelenideElement getStartedButton = $("[class^='button is-white']");
    private SelenideElement titleMoodPanda = $(byXpath("//p[@class='title is-size-1 is-size-2-touch mt-4 mb-5']"));


    public MainPage verificationMainPage() {
        getStartedButton.shouldBe(exist);
        titleMoodPanda.shouldHave(text("MoodPanda"));
        return this;
    }

    public MainPage clickOnGetStarted() {
        getStartedButton.click();
        return this;
    }


}
