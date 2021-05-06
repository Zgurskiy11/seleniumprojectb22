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
        System.out.println("Current title:  "+driver.getTitle());// Current title:  Electric Cars, Solar & Clean Energy | Tesla

       // driver.getCurrentUrl();// if u want to reuse it, u need to save in variable, because its just temporary
        String currentURL=driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);  //   currentURL = https://www.tesla.com/

        // Going back using navigations :
        Thread.sleep(1000);
        driver.navigate().back();

        //Going forward
        Thread.sleep(1000);
        driver.navigate().forward();

        //refreshing
        Thread.sleep(1000);
        driver.navigate().refresh();

        // going to another url using .to() method
        Thread.sleep(1000);
        driver.navigate().to("https://www.google.com");// same as .get, but will not wait till page loaded, before navigating

        System.out.println("Current title:  "+driver.getTitle());//  Current title:  Google
        //System.out.println("currentURL = " + currentURL);// will do tesla again, even though google here.
        // Because of Java rules,: we already assigned the value
        //So we do like this:
        currentURL=driver.getCurrentUrl();// we reassigning
        System.out.println("currentURL = " + currentURL); //  currentURL = https://www.google.com/

        driver.manage().window().maximize();// Maximizes browser size, so u can see All features on the page
        driver.manage().window().fullscreen();// full screen(same, little diff format)

       driver.close();








    }
}
