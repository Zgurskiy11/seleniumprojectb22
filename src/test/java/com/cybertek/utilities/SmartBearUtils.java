package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class SmartBearUtils {


    public static void verifyOrder(WebDriver driver, String name) throws InterruptedException {
        List<WebElement> allNames = driver.findElements(By.xpath("(//table)[2]//tr/td[2]"));
        Thread.sleep(3000);
        for (WebElement eachName : allNames) {
            if (eachName.getText().equals(name)) {
                System.out.println(eachName.getText()+" Found. Congrats!");
                Assert.assertTrue(true);
            }
        }
    }

    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> allNames  = driver.findElements(By.xpath("(//table)[2]//tr/td[2]")); // store all names
        List<WebElement> allCities = driver.findElements(By.xpath("(//table)[2]//tr/td[7]")); // store all cities
          for (int i = 0; i < allNames.size(); i++) {
            System.out.println("Name"+(i+1)+": "+allNames.get(i).getText()+" , City"+(i+1)+": "+allCities.get(i).getText());
        }
    }




}