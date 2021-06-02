package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ConfirmationAlertTC2 {

    WebDriver driver;
    //TC #2: Confirmation alert practice
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    //3. Click to “Click for JS Confirm” button
    //4. Click to OK button from the alert
    //5. Verify “You clicked: Ok” text is displayed.

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void confirmation() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        button.click();
        Thread.sleep(4000);
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();
        WebElement text = driver.findElement(By.cssSelector("p#result"));
        String actualText = text.getText();
        String expectedText = "You clicked: Ok";
        Assert.assertEquals(actualText,expectedText);

    }


}
