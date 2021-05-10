package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankAttributeVerification {
    public static void main(String[] args) {
        /**
         * TC #2: Zero Bank link text verification
         * 1. Open Chrome browser
         * 2. Go to http://zero.webappsecurity.com/login.html
         * 3. Verify link text from top left: Expected: “Zero Bank”
         * 4. Verify link href attribute value contains: Expected: “index.html”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");
        String expectedLinkText = "Zero Bank";
        //locate link and store inside of webElement:
        WebElement zeroBankLink=driver.findElement(By.className("brand"));//WebElement is just data type
        String actualLinkText = zeroBankLink.getText();
        if (actualLinkText.equals(expectedLinkText)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }


        String expectedHref="index.html";
        String actualHref= zeroBankLink.getAttribute("href");
        System.out.println("actualHref = " + actualHref);
if (actualHref.contains(expectedHref)){
    System.out.println("passed");
}else{
    System.out.println("Failed");
}










    }
}
