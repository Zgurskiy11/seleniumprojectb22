package com.cybertek.tests.OfficeHours.OH_day03;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class adidasPractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" https://www.demoblaze.com/index.html");
    }


    @Test
    public void adidasTest(){
        driver.findElement(By.xpath("//a[.='Laptops']")).click();
        BrowserUtils.sleep(2);
    }



}
