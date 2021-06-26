package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BestBuyIQ {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
       // driver.quit();
    }

    @Test
    public void Task() throws InterruptedException {
        driver.get("https://www.bestbuy.ca/en-ca");
        driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("ipad");
        driver.findElement(By.xpath("//a[@href='en-ca/search?search=ipad pro 12.9']")).click();
        //filtering Online only
        driver.findElement(By.xpath("//input[@name='facetFilter-Online Only']")).click();
        //clicking on first one
        driver.findElement(By.xpath("(//div[@class='productItemName_3IZ3c'])[1]")).click();
        //adding to card
        driver.findElement(By.xpath("//div[@class='addToCartLabel_YZaVX']")).click();




    }


}
