package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekUrlVerification {
    public static void main(String[] args) {
        /**
         * TC #2: Cybertekpractice toolverifications
         * 1.Open Chrome browser
         * 2.Go to https://practice.cybertekschool.com
         * 3.Verify URL containsExpected: cybertekschool
         * 4.Verify title: Expected: Practice
         */

        //1 - setup the browser driver
        WebDriverManager.chromedriver().setup();

        //2- create instance of selenium web driver
        //this line opens browser
        WebDriver driver = new ChromeDriver();

        //3-get the page for Chrome.com
        driver.get("http://practice.cybertekschool.com");
        // maximize
        // driver.manage().window().maximize();

        //Verify URL containsExpected: cybertekschool:
        String expectedUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("URL verification pass");
        } else {
            System.out.println("URL verification failed");
        }


        //4 Verify title: Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {  // using .equals
            System.out.println("Title test passed");
        } else {
            System.out.println("Title test failed");
        }


        /**
         * TC #3: Back and forth navigation 1- Open a chrome browser
         * 2- Go to: https://google.com
         * 3- Click to Gmail from top right.
         * 4- Verify title contains: Expected: Gmail
         * 5- Go back to Google by using the .back();
         * 6- Verify title equals: Expected: Google
         */

        driver.get("https:/google.com");
        //Click to Gmail from top right
        driver.findElement(By.linkText("Gmail")).click();
        //Verify title contains: Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualInTitle= driver.getTitle();
        if (actualInTitle.contains(expectedInTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Failed");
        }
//Go back to Google by using the .back()
        driver.navigate().back();
        //Verify title equals: Expected: Google
        String expectedGTitle="Google";
        String actualGTitle= driver.getTitle();
        if (actualGTitle.equals(expectedGTitle)) {
            System.out.println("Title verification passed");
        }else{
            System.out.println("Failed");
        }


    }
}
