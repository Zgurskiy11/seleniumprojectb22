package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//TC #3: Selecting date on dropdown and verifying
// 1.Open Chrome browser
// 2.Go to http://practice.cybertekschool.com/dropdown
// 3.Select  “December 1st, 1922” and verify it is selected.
//           Select year using: visible textSelect
//           month using : value attributeSelect
//           day using: index number

public class TC3Dropdown {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeClass
    public void beforeClass() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void test1() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(2000);
        //3.Select “December 1st, 1921” and verify it is selected
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='year']"));
        Select select = new Select(yearDropdown);
        //Select year using: visible
        select.selectByVisibleText("1922");
        String expectedResult = "1922";
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='month']"));
        Thread.sleep(2000);
        Select select = new Select(monthDropdown);
        //.textSelect month using : value
        select.selectByValue("11");

        String expectedResult = "December";
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement dayDropdown = driver.findElement(By.xpath("//select[@id='day']"));
        Thread.sleep(2000);
        Select select = new Select(dayDropdown);
        //day using: index number
        select.selectByIndex(0);
        String expectedResult = "1";
        String actualResult = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

}