package com.cybertek.tests.day12_actions_upload_JSExecutor;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilPractice {

   @Test
   public void simpleGoogleSearchTest(){

      //1- Go to google.com
      Driver.getDriver().get(ConfigurationReader.getProperty("env"));


      //2- Search for a value
      WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
      String searchValue = "there is no spoon";//can put this string in config.properties
      searchBox.sendKeys(searchValue+ Keys.ENTER);

      //3- Verify value is contained in the title
      String actualTitle = Driver.getDriver().getTitle();
      Assert.assertTrue(actualTitle.contains(searchValue));

      Driver.closeDriver();//using our method//  will terminate session and assign driver value to null


   }

}
