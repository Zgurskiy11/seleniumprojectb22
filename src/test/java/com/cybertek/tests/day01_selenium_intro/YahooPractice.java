package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();//opens empty browser

        driver.manage().window().maximize();// maximizing browser
        driver.get("https://www.chrome.com");
        driver.navigate().to("https://www.yahoo.com");

        String expectedTitle="Yahoo";
        String actualTitle=driver.getTitle();// assigning Title to String variable ,,actual value comes from browser

        if (actualTitle.equalsIgnoreCase((expectedTitle))){// comparing Strings
            System.out.println("Test Passed");
        }else{
            System.out.println("Wrong title");
        }
        driver.close();// closing current browser
    }
}
