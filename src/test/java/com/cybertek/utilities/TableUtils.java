package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TableUtils {
    /*
    PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in TableUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

    public static void verifyOrder(WebDriver driver, String name){

        //locate all the names from table and store them in List
        //to introduce local variable option+enter
      List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));
        for (WebElement each : allNames) {  //looping thru
            System.out.println(each.getText());//all names from table. Printing just to see
            if (each.getText().equals(name)) {
                Assert.assertTrue(true);
                return;//exiting method if Tim is found
            }
        }  //failing Assert outside of the loop-->
                Assert.fail("fix this issue ASAP");//other way to do failing part of assertion
              //  Assert.assertTrue(false);//other way
            }
        }

