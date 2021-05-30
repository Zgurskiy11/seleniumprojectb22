package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Carmax {
    //Go to carmax.com web and click on the dropdown menu "MORE" and choose "Home Delivery"
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.carmax.com");
                Thread.sleep(3000);
        WebElement dropDownMore = driver.findElement(By.xpath("//button[@id='header-helpful-links-button']"));
        dropDownMore.click();

        driver.findElement(By.xpath("//a[@href='/home-delivery']")).click();

        driver.close();
    }
}