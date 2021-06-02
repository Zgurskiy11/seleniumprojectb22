package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day6Dropdowns {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void test() {
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
    }

    @Test
    public void test2() {
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("IL");
        String expected = "Illinois";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void test3() {
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("VA");
        String expected = "Virginia";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void test4() {
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("CA");
        String expected = "California";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void test5() {
        Select select = new Select(driver.findElement(By.id("year")));
        select.selectByVisibleText("1922");
        String expected = "1922";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test6() {
        Select select = new Select(driver.findElement(By.id("month")));
        select.selectByValue("11");
        String expected = "December";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void test7() {
        Select select = new Select(driver.findElement(By.id("day")));
        select.selectByIndex(0);
        String expected = "1";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void test8() throws InterruptedException {
        Select select = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> options = select.getOptions();
        for (WebElement option: options){
            select.selectByVisibleText(option.getText());
        }
        List<WebElement> selected = select.getAllSelectedOptions();
        for(WebElement option : selected){
            System.out.println(option.getText());
        }
        select.deselectAll();


    }

    @Test
    public void test9()  {
        WebElement drop = driver.findElement(By.id("dropdownMenuLink"));
        WebElement op = driver.findElement(By.xpath("//a[.='Facebook']"));
        drop.click();
        op.click();
        String expTitle="Facebook - Log In or Sign Up";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"***this message if assertion Fails***");
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }

}

