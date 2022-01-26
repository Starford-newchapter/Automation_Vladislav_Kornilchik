package Practic;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice {

    WebDriver driver = new ChromeDriver();
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @BeforeTest
    public void setUp() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.manage().window().setSize(new Dimension(1552, 840));
    }

    @Test
    public void calculateCategoryInKg() {
        driver.findElement(By.xpath("//*[@name='wg']")).sendKeys("70");
        driver.findElement(By.xpath("//*[@name='opt2']")).click();
        driver.findElement(By.xpath("//*[@name='opt2']/option[2]")).click();
        driver.findElement(By.xpath("//*[@name='opt3']")).click();
        driver.findElement(By.xpath("//*[@name='opt3']/option[4]")).click();
        jse.executeScript("scroll(0, 800);");
        driver.findElement(By.name("cc")).click();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();




    }


}
