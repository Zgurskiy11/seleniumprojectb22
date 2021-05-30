package com.cybertek.tests.home_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        //verify header"Connect with friends..." on main page
        driver.findElement(By.className("_8eso")).getText();// without text would be WebElement
         String expectedHeader="Connect with friends and the world around you on Facebook.";
        String actual= driver.findElement(By.className("_8eso")).getText();// .text makes it string
        if (actual.equals(expectedHeader)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }





    }
}
