package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {



        //1 - setup the browser driver
        WebDriverManager.chromedriver().setup();

        //2- create instance of selenium web driver
        //this line opens browser
        WebDriver driver=new ChromeDriver();

        //3-get the page for Tesla.com
        driver.get("https://www.tesla.com");
      //  driver.get("https://tesla.com");  works too , but better put www.

        // Going back using navigations :
        Thread.sleep(3000);
        driver.navigate().back();






    }
}
