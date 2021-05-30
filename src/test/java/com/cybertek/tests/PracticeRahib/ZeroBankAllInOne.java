package com.cybertek.tests.PracticeRahib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class ZeroBankAllInOne {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver ramin = new ChromeDriver();// making Ramin our driver
        ramin.get("http://zero.webappsecurity.com/");
        ramin.manage().window().maximize();

     //   ramin.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//instead of sleep

        ramin.findElement(By.id("signin_button")).click();
        ramin.findElement(By.id("user_login")).sendKeys("username");
        ramin.findElement(By.name("user_password")).sendKeys("password"+ Keys.ENTER);
        Thread.sleep(2000);
       ramin.findElement(By.id("details-button")).click();

        Thread.sleep(3000);

        ramin.findElement(By.id("proceed-link")).click();
        ramin.findElement(By.id("transfer_funds_tab")).click();


        Thread.sleep(3000);

        WebElement dropDown1Menu = ramin.findElement(By.id("tf_fromAccountId"));
        dropDown1Menu.click();

        Select savings = new Select(dropDown1Menu);//we imported Select class
        savings.selectByValue("3");// 3 is savings variable,, also can go to checking
        Thread.sleep(3000);

        WebElement dropDownMenuChecking = ramin.findElement(By.id("tf_toAccountId"));
        dropDownMenuChecking.click();

        Select checking = new Select(dropDownMenuChecking);
        checking.selectByValue("2");

        Thread.sleep(3000);

        ramin.findElement(By.className("input-small")).sendKeys("750");

        Thread.sleep(3000);
        ramin.findElement(By.id("tf_description")).sendKeys("Save someone from Bankruptcy :)");

        ramin.findElement(By.id("btn_submit")).click();
        Thread.sleep(3000);

        ramin.findElement(By.id("btn_submit")).click();











          ramin.close();


    }
}
