package Lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.awt.SystemColor.window;

public class Lecture_4 {

    WebDriver driver = new ChromeDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    @BeforeTest
    public void setUp() {
        driver.get("https://www.google.by/");
        driver.findElement(By.cssSelector("input.gLFyf")).sendKeys("Привет,мир");
        driver.findElement(By.cssSelector(".LLD4me")).click();
        driver.findElement(By.cssSelector("center:nth-child(1)>.gNO89b")).click();
    }

    @Test
    public void checkHelloWord_1() {
        String helloWord = driver.findElement(By.cssSelector("div:nth-child(2) > .tF2Cxc > .yuRUbf .LC20lb")).getText();
        Assert.assertTrue(helloWord.contains("Привет, Мир!"));
        jse.executeScript("scroll(0, 600);");
    }

    @Test
    public void checkHelloWord_2() {
        String helloWord = driver.findElement(By.cssSelector(".g:nth-child(4) .LC20lb")).getText();
        Assert.assertTrue(helloWord.contains("Привет, Мир!"));
        jse.executeScript("scroll(0, 250);");
    }

    @Test
    public void checkHelloWord_3() {
        String helloWord = driver.findElement(By.cssSelector(".NJo7tc .LC20lb")).getText();
        Assert.assertTrue(helloWord.contains("Привет, Мир!"));
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}
