package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriver driver=new ChromeDriver();

        //3-get the page for Chrome.com
        driver.get("http://practice.cybertekschool.com");
        // maximize
        driver.manage().window().maximize();

        //Verify URL containsExpected: cybertekschool:
        String expectedUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL verification pass");
        }else{
            System.out.println("URL verification failed");
        }


        //4 Verify title: Expected: Practice



















    }
}
