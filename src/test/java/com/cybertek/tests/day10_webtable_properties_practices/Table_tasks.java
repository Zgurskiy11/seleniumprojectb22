package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Table_tasks extends TestBase {


    @Test
    public void task3_return_tims_due_amount() {
        //1.	Open browser and go to: http://practice.cybertekschool.com/tables#edit
        //2.	Locate first table and verify Tim has due amount of “$50”
        ////table[@id='table1']//td[.='Tim'] will ALWAYS find Tim
        //table[@id='table1']//td[.='Tim']/../td[4] -->$50(amount of Tim
        //or preceding sibling method:
        ////table[@id='table1']//td[.='Tim']/following-sibling::td[2]
        //Note: Create locator for Tim that will be dynamic and doesnt care in which row Tim is.
        driver.get(ConfigurationReader.getProperty("dataTablesUrl"));//doing same thing for link just without creating variable

        WebElement timsDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]"));
        System.out.println("timsDueAmount.getText() = " + timsDueAmount.getText());
        String actual = timsDueAmount.getText();
        String expected = "$50.00";
        Assert.assertEquals(actual, expected, "Cell not returning what expected(");//message optional


    }

    @Test
    public void task4_verify_order_method() {
        String url = ConfigurationReader.getProperty("dataTablesUrl");
        driver.get(url);
        TableUtils.verifyOrder(driver, "Tim");

    }

}
