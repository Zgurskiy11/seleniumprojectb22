package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PromtAlert {
    WebDriver driver;
    //TC #3: Promt alert practice
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    //3. Click to “Click for JS Prompt” button
    //4. Send “hello” text to alert
    //5. Click to OK button from the alert
    //6. Verify “You entered: hello” text is displayed.


    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void promtAlert() throws InterruptedException {

        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
        button.click();
        Thread.sleep(2000);
        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys("hello"+ Keys.ENTER);
        Thread.sleep(2000);
        promtAlert.accept();


        WebElement text = driver.findElement(By.cssSelector("p#result"));
        String actualText = text.getText();
        String expectedText = "You entered: hello";
        Assert.assertEquals(actualText,expectedText);
    }



}
