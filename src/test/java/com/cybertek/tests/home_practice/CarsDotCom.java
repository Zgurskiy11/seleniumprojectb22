package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CarsDotCom {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.cars.com");
        WebElement lexus = driver.findElement(By.xpath("//select[@name='makeId']"));
        lexus.click();
        Select select = new Select(lexus);
        select.selectByVisibleText("Lexus");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }
}
