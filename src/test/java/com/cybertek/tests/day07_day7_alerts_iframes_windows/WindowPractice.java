package com.cybertek.tests.day07_day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowPractice {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");

    }

    @Test
    public void window_test(){
        //Printing out the window handle of the first page opened
        //Storing the first windowHandle into a string is a useful practice for future needs when we need
        // to switch back to it
                String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Practice”
        String actualTitleBeforeClick = driver.getTitle();
        String expectedTitleBeforeClick = "Practice";
//lets just print out
        System.out.println("actualTitleBeforeClick = " + actualTitleBeforeClick);
        //and compare
        Assert.assertEquals(actualTitleBeforeClick,expectedTitleBeforeClick);

        //5. Click to: “Click Here” text
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        //title after click
        String actualTitleAfterClick = driver.getTitle();// still practice
        System.out.println("actualTitleAfterClick = " + actualTitleAfterClick);//practice

        for (String each : driver.getWindowHandles()) {
            //here can add if condition .getTitle.contains("something"). Its gonna switch to the page u want and brake the loop
            driver.switchTo().window(each);
            System.out.println("CURRENT TITLE WHILE SWITCHING: " + driver.getTitle());//title is important for us
        }

        //6. Switch to new Window.
        System.out.println(driver.getTitle());


        //7. Assert: Title is “New Window”
    }




}
