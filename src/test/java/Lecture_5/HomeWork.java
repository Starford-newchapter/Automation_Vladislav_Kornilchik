package Lecture_5;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeWork {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Открыть сайт https://masterskayapola.ru/kalkulyator/laminata.html
Ввести параметры для расчета.
Нажать на кнопку ‘Рассчитать’.
Проверить полученные значения.
Закрыть окно браузера.

     */

    @Test(dataProvider = "data")
    public void calculateLaminateInstallation(String roomLength,String roomWidth,String laminateLength,String laminateWidth,String count,String priceOf,String biasOf,String walldistOf) {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        //WebElements
        WebElement lengthRoom = driver.findElement(By.name("calc_roomwidth"));
        WebElement widthRoom = driver.findElement(By.name("calc_roomheight"));

        WebElement lengthLaminate = driver.findElement(By.name("calc_lamwidth"));
        WebElement widthLaminate = driver.findElement(By.name("calc_lamheight"));
        WebElement countInPack = driver.findElement(By.name("calc_inpack"));
        WebElement price = driver.findElement(By.name("calc_price"));

        WebElement setDirection = driver.findElement(By.name("calc_direct"));
        Select selectDirection = new Select(setDirection);

        WebElement bias = driver.findElement(By.name("calc_bias"));
        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        WebElement calcBtn = driver.findElement(By.cssSelector(".form_element .btn"));

        //Action


        clearArea(lengthRoom);
        lengthRoom.sendKeys(roomLength);
        clearArea(widthRoom);
        widthRoom.sendKeys(roomWidth);
        clearArea(lengthLaminate);
        lengthLaminate.sendKeys(laminateLength);
        clearArea(widthLaminate);
        widthLaminate.sendKeys(laminateWidth);
        clearArea(countInPack);
        countInPack.sendKeys(count);
        clearArea(price);
        price.sendKeys(priceOf);

        selectDirection.selectByValue("toh");
        clearArea(bias);
        bias.sendKeys(biasOf);
        clearArea(walldist);
        walldist.sendKeys(walldistOf);
        calcBtn.click();




    }

    @DataProvider(name="data")
    private Object[][] getData(){
        return  new Object[][]{
                {"10","8","2000","200","15","500","300","12"},{"11","3","3000","300","16","`1000`","500","10"},{"13","4","2500","100","20","`1300`","550","8"}};

        }



    public void clearArea(WebElement webElement) {
        webElement.click();
        while (webElement.getAttribute("value").length() != 0) {
            webElement.sendKeys(Keys.BACK_SPACE);


        }


    }


}
