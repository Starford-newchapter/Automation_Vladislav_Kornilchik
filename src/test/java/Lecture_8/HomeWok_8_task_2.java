package Lecture_8;

import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeWok_8_task_2 extends BaseTest {

    @Test
    public void Lecture_8_task_2(){
        driver.get("C:\\Users\\ua.karnilchyk\\IdeaProjects\\Automation(Vladislav_Kornilchik)\\src\\test\\java\\Lecture_8\\site_check.html");
        List<WebElement> table=driver.findElements(By.xpath("//tbody//following::tr//td[1]"));
        WebElement userNameInput=driver.findElement(By.id("username"));
        WebElement checkbox=driver.findElement(By.id("vehicle1"));
        WebElement cars=driver.findElement(By.id("cars"));
        Select selectCar=new Select(cars);

        WebElement button=driver.findElement(By.xpath("//input[@type='submit']"));
        WebElement image=driver.findElement(By.tagName("img"));
        WebElement link=driver.findElement(By.cssSelector("a[href]"));

        List<String> actualTableText=new ArrayList<>(){{
            table.forEach((elements)->add(elements.getText()));
        }};
        List<String>expectedText=new ArrayList<>(){{
            add("Alfreds Futterkiste");
            add("Centro comercial");
            add("Ernst Handel");
            add("Island Trading");
        }};

        userNameInput.sendKeys("Name");
        checkbox.click();
        selectCar.selectByIndex(3);
        button.click();
        Assert.assertEquals(actualTableText,expectedText);
        Assert.assertTrue(image.isDisplayed());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"Learn how to write Html page");
       link.click();
       Assert.assertTrue(driver.findElement(By.xpath("//*[@rel='author']")).isDisplayed());











    }

}
