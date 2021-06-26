package com.cybertek.tests.home_practice;

import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4AndTC5 {

    WebDriver driver;
    String userName = "Tester";
    String passWord = "test";

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        loginSmartBear(userName , passWord);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    public void loginSmartBear(String userName , String passWord) throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.xpath("//input[@class='txt'][1]")).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='txt'][2]")).sendKeys(passWord);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();
    }

    @Test
    public void test1() throws InterruptedException {
        SmartBearUtils.verifyOrder(driver, "Bob Feather");
    }

    @Test
    public void test2() throws InterruptedException {
        SmartBearUtils.printNamesAndCities(driver);
    }

}
