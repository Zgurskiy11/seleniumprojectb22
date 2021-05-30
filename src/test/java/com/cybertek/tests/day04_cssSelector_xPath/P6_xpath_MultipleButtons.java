package com.cybertek.tests.day04_cssSelector_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_xpath_MultipleButtons {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
/**
 * TC #6: XPATH LOCATOR practice
 * 1. Open Chrome browser
 * 2. Go to http://practice.cybertekschool.com/multiple_buttons
 * 3. Click on Button 1
 * 4. Verify text displayed is as expected:
 * Expected: “Clicked on button one!”
 */

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button1= driver.findElement(By.xpath("//button[@onclick='button1()']"));  // can use class attr too
      //  WebElement button1= driver.findElement(By.xpath("//button[.='Button 1']"));  another way,, by text

        button1.click();

        WebElement resultText=driver.findElement(By.xpath("//p[@id = 'result']"));
        String expectedText="Clicked on button one!";
        String actualText=resultText.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }



    }
}
