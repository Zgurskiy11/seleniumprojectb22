package com.cybertek.tests.day06_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CybertekCheckboxes {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Practice: Cybertek Checkboxes
        //1. Go to http://practice.cybertekschool.com/checkboxes
        //2. Confirm checkbox #1 is NOT selected by default
        //3. Confirm checkbox #2 is SELECTED by default.
        //4. Click checkbox #1 to select it.
        //5. Click checkbox #2 to deselect it.
        //6. Confirm checkbox #1 is SELECTED.
        //7. Confirm checkbox #2 is NOT selected.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement box1 = driver.findElement(By.xpath("//input[@id='box1']"));// or can put (type = 'checkbox')[1]
        System.out.println("box1.isSelected() = " + box1.isSelected());
        WebElement box2 = driver.findElement(By.xpath("//input[@id='box2']"));//                               [2]
        System.out.println("box2.isSelected() = " + box2.isSelected());//true

        box1.click();
        box2.click();

        System.out.println("box1.isSelected() after changes  " + box1.isSelected());
        System.out.println("box2.isSelected() after changes  " + box2.isSelected());


        driver.quit();
    }
}
