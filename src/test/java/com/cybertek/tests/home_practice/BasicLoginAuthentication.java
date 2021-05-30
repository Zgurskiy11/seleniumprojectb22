package com.cybertek.tests.home_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLoginAuthentication {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String expectedTitle="Web Orders Login";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String expected="Web Orders";
        String actual=driver.getTitle();
        if (actual.equals(expected)){
            System.out.println("title test pass");
        }else{
            System.out.println("title test failed");
        }


    }





}
