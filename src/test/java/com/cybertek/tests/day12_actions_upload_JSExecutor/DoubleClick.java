package com.cybertek.tests.day12_actions_upload_JSExecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {

    @Test
    public void doubleClick(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        //switching to iframe using id
        driver.switchTo().frame("iframeResult");
        //locating text, that we need to double click on:
        WebElement clickText = driver.findElement(By.xpath("//p[@id='demo']"));
        //calling ActionS class
        Actions x = new Actions(driver);
        //performing double click
        x.doubleClick(clickText).perform();

        //checking if element displayed, with style containing red
        Assert.assertTrue((driver.findElement(By.xpath("//p[contains(@style,'red')]"))).isDisplayed());
        //closing session
        Driver.closeDriver();

    }
}
