package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_CybertekTitleVerification {
    public static void main(String[] args) throws InterruptedException {
/**
 * TC #6: Practice Cybertek – Class locator practice
 * 1. OpenChrome browser
 * 2. Go to http://practice.cybertekschool.com/inputs
 * 3. Click“Home”button
 * 4. Verify title as expected:
 * Expected: Practice
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/inputs");

        Thread.sleep(1000);
        driver.findElement(By.className("nav-link")).click();// inspected home button on our website , and found nav-link
        String expectedResult = "Practice";
        String actualResult = driver.getTitle();
        if (actualResult.equals(expectedResult)) {
            System.out.println("Etsy title passed!");
        } else {
            System.out.println("Etsy title verification failed!");
        }















    }
}
