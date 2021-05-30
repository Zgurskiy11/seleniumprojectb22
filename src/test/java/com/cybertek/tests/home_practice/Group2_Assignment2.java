package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Group2_Assignment2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //login for Truck Driver
        driver.get("https://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Username or Email']")).sendKeys("user4");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        //  System.out.println("actualTitle = " + actualTitle);
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Driver log in successful");
        } else {
            System.out.println("Login error");
        }
        driver.quit();
    }
}
