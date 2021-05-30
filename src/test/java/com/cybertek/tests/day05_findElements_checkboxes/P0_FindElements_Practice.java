package com.cybertek.tests.day05_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0_FindElements_Practice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //TC #0: FINDELEMENTS
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password
        //3. Print out the texts of all links
        //4. Print out how many total link

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//will wait up to 15 sec,, if earlier->move on
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // we need to create locator that returns all links on the page
        //body//a ---> this locator will do it
        //we are storing all of the links that are returned by findElements method
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        for (WebElement each : listOfLinks) {

            System.out.println(each.getText());//returns 2 strings
            System.out.println(each.getAttribute("href"));//giving us Attributes value
            System.out.println(listOfLinks.size());//number of links, or create int variable for cleaner code

        }






    }
}
