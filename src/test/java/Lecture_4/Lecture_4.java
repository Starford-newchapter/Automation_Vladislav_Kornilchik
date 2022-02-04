package Lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_4 {

    WebDriver driver = new ChromeDriver();
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @BeforeTest
    public void setUp() {
        driver.get("https://www.google.by/");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Привет,мир");
        driver.findElement(By.cssSelector("center:nth-child(1) .gNO89b")).click();
    }

    @Test(priority = 1)
    public void checkHelloWorldInSearchString() {
        String helloWord = driver.findElement(By.cssSelector("input.gLFyf")).getAttribute("value");
        Assert.assertEquals(helloWord, "Привет,мир");

    }

    @Test(priority = 2)
    public void checkHelloWordInLink_1() {
        String helloWord = driver.findElement(By.cssSelector("div:nth-child(2) > .tF2Cxc > .yuRUbf .LC20lb")).getText();
        Assert.assertTrue(helloWord.contains("Привет, Мир!"));
        jse.executeScript("scroll(0, 600);");
    }

    @Test(priority = 3)
    public void checkHelloWordInLink_2() {
        String helloWord = driver.findElement(By.cssSelector(".g:nth-child(4) .LC20lb")).getText();
        Assert.assertTrue(helloWord.contains("Привет, Мир!"));
        jse.executeScript("scroll(0, 250);");
    }

    @Test(priority = 4)
    public void checkHelloWordInLink_3() {
        String helloWord = driver.findElement(By.cssSelector(".NJo7tc .LC20lb")).getText();
        Assert.assertTrue(helloWord.contains("Привет, Мир!"));
    }

    @Test(priority = 5)
    public void searchNotFound() {
        driver.findElement(By.cssSelector("input.gLFyf")).clear();
        driver.findElement(By.cssSelector("input.gLFyf")).sendKeys("*//*");
        driver.findElement(By.cssSelector("button.Tg7LZd")).click();
        String notFound = driver.findElement(By.cssSelector(".card-section p:nth-child(1)")).getText();
        Assert.assertTrue(notFound.contains("ничего не найдено"));


    }


}
