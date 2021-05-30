package com.cybertek.tests.home_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookIncorrectLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//negative data
        driver.get("https://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("erf");
        driver.findElement(By.name("pass")).sendKeys("f8f43r");
        driver.findElement(By.name("login")).click();

        String expectedTitle="Log into Facebook";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test pass");
        }else{
            System.out.println("Test fail");
        }




    }
}
