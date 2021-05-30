package com.cybertek.tests.day04_cssSelector_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_cssSelector_Amazon {
    public static void main(String[] args) {
        /**
         * CSS Practice
         * DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
         * TC #3: Amazon link number verification
         * 1. Open Chrome browser
         * 2. Go to https://www.amazon.com/
         * 3. Enter search term (use cssSelector to locate search box)
         * 4. Verify title contains search term
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement amazonSearchBar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));//search box
        amazonSearchBar.sendKeys("Wooden spoon" + Keys.ENTER);
        String expectedTitle = "Amazon.com : Wooden spoon";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("pass");
        }else{
            System.out.println("Fail");
        }















    }
}
