package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OscarUtil {

    public static void settingCredentials(WebDriver driver,String name, String password){
        driver.get(" http://thedemosite.co.uk/addauser.php");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='button']")).click();
    }
}
