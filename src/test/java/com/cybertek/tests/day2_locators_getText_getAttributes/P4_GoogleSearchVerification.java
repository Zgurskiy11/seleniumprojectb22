package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearchVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);// puts apple in search box
        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";

        if (actualTitle.startsWith(expectedTitle)) {// we know its starting with apple for sure
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }


    }
}
