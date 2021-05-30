package com.cybertek.tests.PracticeRahib.Practice_05_21_21;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_1 {
    public static void main(String[] args) {
        //TEST CASE:
        //- access to the login page
        //- check if you are on the expected login page
        //- correct username and password
        //- access to the dashboard
        //- check the title after login - if correct with the expected
        //- check if the login title is NOT the same as the Dashboard Title.
        // If not - Passed
        //Username: Storemanager201   ,  Password: UserUser123
        //https://qa3.vytrack.com/user/login

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";

        String check = actualTitle.equals(expectedTitle)?"Passed":"Failed";
        System.out.println(check);//passed

        WebElement usernameLoginPage = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameLoginPage.sendKeys("Storemanager201");
        WebElement passwordLoginPage = driver.findElement(By.xpath("//input[@id='prependedInput2']"));//or //*[@type='password'],,,.unique too
        passwordLoginPage.sendKeys("UserUser123");
        passwordLoginPage.submit();// can use this method, submit().

        String actualTitle02 = driver.getTitle();
       // System.out.println(driver.getTitle());   here we getting title
        String expectedTitle02 = "Dashboard";
        String check2 = actualTitle02.equals(expectedTitle02)?"passed":"failed";
        System.out.println("check2 = " + check2);//passed

        String checkLoginVSDashboard = actualTitle02.equals(actualTitle)?"Failed":"Passed";// or String check2 = !currentTitle.equals(expectedTitle) ? "Test Passed" : "Test Failed";
        System.out.println("checkLoginVSDashboard = " + checkLoginVSDashboard);


        driver.quit();




    }
}
