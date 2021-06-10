package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Table_tasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        String browser = ConfigurationReader.getProperty("browser");//passing KEY of the value we need. Its in configuration file we created
        driver = WebDriverFactory.getDriver(browser);//passing browser var we just created here
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("dataTablesUrl"));//doing same thing for link just without creating variable

    }

    @Test
    public void task3_return_tims_due_amount(){
        //1.	Open browser and go to: http://practice.cybertekschool.com/tables#edit
        //2.	Locate first table and verify Tim has due amount of “$50”
        ////table[@id='table1']//td[.='Tim'] will ALWAYS find Tim
        //table[@id='table1']//td[.='Tim']/../td[4] -->$50(amount of Tim
        //or preceding sibling method:
        ////table[@id='table1']//td[.='Tim']/following-sibling::td[2]
        //Note: Create locator for Tim that will be dynamic and doesnt care in which row Tim is.

        WebElement timsDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));
        System.out.println("timsDueAmount.getText() = " + timsDueAmount.getText());
        String actual = timsDueAmount.getText();
        String expected = "$50.00";
        Assert.assertEquals(actual,expected,"Cell not returning what expected(");//message optional


    }

    @Test
    public void task4_verify_order_method(){
        TableUtils.verifyOrder(driver, "Tim");

    }

}
