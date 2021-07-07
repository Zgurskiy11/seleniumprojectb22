package com.cybertek.tests.PracticeRahib;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Interview {

    @Test
    public void Test() {
        Driver.getDriver().get("https://www.amazon.com/");
        WebElement q = Driver.getDriver().findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        Actions x = new Actions(Driver.getDriver());
        x.moveToElement(q).perform();
        WebElement signIn = Driver.getDriver().findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
        Assert.assertTrue(signIn.isDisplayed());
    }
}
