package com.cybertek.tests.home_practice;

import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC4AndTC5 {

    WebDriver driver;
    String userName = "Tester";
    String passWord = "test";

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        loginSmartBear(userName , passWord);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public void loginSmartBear(String userName , String passWord) throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.xpath("//input[@class='txt'][1]")).sendKeys(userName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='txt'][2]")).sendKeys(passWord);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();
    }

//    public boolean verifyOrder(WebDriver driver , String name){
//        List<WebElement> allNames = driver.findElements(By.xpath("(//table)[2]//tr/td[2]"));
//
//        for (WebElement eachName : allNames) {
//            if (eachName.getText().equals(name)){
//                return true;
//            }
//        }
//        return false;
//    }


    public void printNamesAndCities(){
        List<WebElement> allNames  = driver.findElements(By.xpath("(//table)[2]//tr/td[2]")); // store all names
        List<WebElement> allCities = driver.findElements(By.xpath("(//table)[2]//tr/td[7]")); // store all cities
        //•Name1: name , City1: city
        // •Name2: name , City2: city

        for (int i = 0; i < allNames.size(); i++) {
            System.out.println("Name"+(i+1)+": "+allNames.get(i).getText()+" , City"+(i+1)+": "+allCities.get(i).getText());
        }
    }


    @Test
    public void test1() throws InterruptedException {

        String name = "Charles Dodgeson";
       // boolean expectedResult = true;
        boolean actualResult= SmartBearUtils.verifyOrder(driver,name);
        Assert.assertTrue(actualResult);
      //  System.out.println("actualResult = " + actualResult);
    }
    @Test
    public void test2() throws InterruptedException {
        printNamesAndCities();
    }

}
