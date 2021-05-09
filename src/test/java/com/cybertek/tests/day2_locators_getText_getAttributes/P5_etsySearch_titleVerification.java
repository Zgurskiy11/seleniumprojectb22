package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_etsySearch_titleVerification {
    public static void main(String[] args) {
        /**
         * TC #1: Etsy Title Verification
         * 1. Open Chrome browser
         * 2. Go to https://www.etsy.com/
         * 3. Search for “wooden spoon”
         * 4. Verify title: Expected: “Wooden spoon | Etsy”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
       // driver.findElement(By.id("global-enhancements-search-query"));// locating web element
     //   driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Wooden Spoon");// puts wooden spoon in search box
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Wooden Spoon"+ Keys.ENTER);

    }
}
