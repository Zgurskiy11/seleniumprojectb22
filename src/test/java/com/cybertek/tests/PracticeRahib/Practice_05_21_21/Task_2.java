package com.cybertek.tests.PracticeRahib.Practice_05_21_21;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Task_2 {
    public static void main(String[] args) {
        //Test Case NO=1
        //Amazon.com Search "Wooden Spoon"
        //1. Build the WebDriverManager and call Chrome Driver
        // 2. Go to Amazon.com
        // 3. Locate the amazon search bar
        //4. Send "Wooden Spoon" and click search
        //5. Check the title with if conditon

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("wooden spoon" + Keys.ENTER);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com : wooden spoon";
        System.out.println("driver.getTitle() = " + driver.getTitle());
        if (actualTitle.equals(expectedTitle)){
            System.out.println("pass");
        }else{
            System.out.println("Fail");
        }

    }
}
