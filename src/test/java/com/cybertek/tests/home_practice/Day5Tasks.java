package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day5Tasks {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeClass
    public void beforeMethod() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        Thread.sleep(2000);

        boolean actualResult = driver.findElement(By.xpath("//div[@id='txtAge']")).isDisplayed();

        if (!actualResult) {
            System.out.println("test pass");
        }else{
            System.out.println("test fail");
        }

        WebElement x = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        x.click();
        String y =driver.findElement(By.xpath("//div[@id='txtAge']")).getText();
        if (y.equals("Success - Check box is checked")){
            System.out.println("Test Pass");
        }else{
            System.out.println("test fail");
        }

    }

    @Test
    public void test2(){
        //TC #3: SeleniumEasy Checkbox Verification – Section 2
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
         driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
         //3. Verify “Check All” button text is “Check All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@id='check1']"));
        String actualText = checkAllButton.getAttribute("value");
        String expectedText = "Check All";
        if (actualText.equals(expectedText)){
            System.out.println("Button text verification passed!");
        }else{
            System.out.println("Button text verification failed!!!");
        }
        //4. Click to “Check All” button
        checkAllButton.click();
        //5. Verify all check boxes are checked
        List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement checkbox : checkboxList){
            if (checkbox.isSelected()){
                System.out.println("Checkbox is selected. PASS!");
            }else{
                System.out.println("Checkbox is NOT selected. FAIL!");
            }
        }
        //6. Verify button text changed to “Uncheck All”

         String actualButtonTextAfterClick = checkAllButton.getAttribute("value");
        String expectedValueAfterClick = "Uncheck All";
        if (actualButtonTextAfterClick.equals(expectedValueAfterClick)){
            System.out.println("Final verification PASSED!");
        }else{
            System.out.println("Final verification FAILED!!!");
        }
    }
}






