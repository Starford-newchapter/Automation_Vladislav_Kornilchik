package Lecture_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lecture_3 {
    WebDriver webDriver=new ChromeDriver();

    @Test
    public void  test_1(){
        webDriver.get("https://www.instagram.com/");
        webDriver.findElement(By.className("Зарегистрироваться")).click();

    }
}
