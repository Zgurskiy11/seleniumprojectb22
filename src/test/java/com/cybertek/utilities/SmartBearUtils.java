package com.cybertek.utilities;

import com.cybertek.tests.home_practice.TC4AndTC5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SmartBearUtils {


    public static boolean verifyOrder(WebDriver driver, String name) throws InterruptedException {
        TC4AndTC5 x = new TC4AndTC5();
        x.loginSmartBear("Tester", "test");
        Thread.sleep(4000);
        List<WebElement> allNames = driver.findElements(By.xpath("(//table)[2]//tr/td[2]"));

        for (WebElement eachName : allNames) {
            if (eachName.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }
}