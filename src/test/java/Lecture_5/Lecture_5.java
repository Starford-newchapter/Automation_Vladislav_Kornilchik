package Lecture_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lecture_5 {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }


    @Test(enabled = false)
    public void smokeTest_1() {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela");
        WebElement height = driver.findElement(By.cssSelector("[name='ht']"));
        WebElement weight = driver.findElement(By.name("mass"));
        WebElement button = driver.findElement(By.xpath("//input[@value='Рассчитать']"));
        WebElement result = driver.findElement(By.name("result"));
        WebElement imt = driver.findElement(By.id("resline"));

        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();

        //Checks
        String actualResult = result.getAttribute("value");
        String actualResultImt = imt.getText();

        Assert.assertEquals(actualResult, "17.32");
        Assert.assertEquals(actualResultImt, "Недостаточной массе тела");


    }

    @Test(dataProvider = "data")
    public void smokeTest_2(String cr, String ag, String wei, String hei, List<String> expectedData) {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement gender = driver.findElement(By.name("sex"));
        Select selectGender = new Select(gender);

        WebElement creatin = driver.findElement(By.id("oCr"));
        WebElement age = driver.findElement(By.id("oAge"));
        WebElement weight = driver.findElement(By.id("oWeight"));
        WebElement height = driver.findElement(By.id("oHeight"));
        WebElement calculateBtn = driver.findElement(By.cssSelector("[value='Рассчитать']"));
        List<WebElement> results = driver.findElements(By.xpath("//form//li//div"));

        //Actions
        selectGender.selectByIndex(1);
        creatin.sendKeys(cr);
        age.sendKeys(ag);
        height.sendKeys(wei);
        weight.sendKeys(hei);
        calculateBtn.click();


        List<String> actualData = new ArrayList<String>() {
            {
                results.forEach(webElement -> add(webElement.getText()));
            }
        };


        Assert.assertEquals(actualData, expectedData);


    }

    @DataProvider(name = "data")
    private Object[][] getData() {
        return new Object[][]{
                {"80", "38", "55", "163", new ArrayList<String>() {{
                    add("MDRD: 74 (мл/мин/1,73кв.м)");
                    add("ХБП: 2 стадия (при наличии почечного повреждения)");
                    add("Cockroft-Gault: 208 (мл/мин)");
                    add("Поверхность тела:1.14 (кв.м)");

                }}},
                {"80", "100", "3", "2", new ArrayList<String>() {{
                    add("MDRD: 74 (мл/мин/1,73кв.м)");
                    add("ХБП: 2 стадия (при наличии почечного повреждения)");
                    add("Cockroft-Gault: 208 (мл/мин)");
                    add("Поверхность тела:1.14 (кв.м)");

                }}}
        };
    }


    @AfterTest
    public void close() {
        driver.quit();
    }
}
