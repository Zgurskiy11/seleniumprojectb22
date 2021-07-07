package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.DynamicLoad1Page;
import com.cybertek.pages.DynamicLoad7Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class WebDriverWaitPractice {  //practicing waits

    /**
     * TC#40 : Dynamically Loaded Page Elements 7
     * 1. Go to http://practice.cybertekschool.com/dynamic_loading/7
     * 2. Wait until title is “Dynamic title”
     * 3. Assert : Message “Done” is displayed.
     * 4. Assert : Image is displayed.
     */
    @Test
    public void  dynamic_loading_7_test(){
        DynamicLoad7Page x = new DynamicLoad7Page();//creating object of our POM(page object model)
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        // now wait. passing driver and 10 seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //use the object to wait for Explicit condition:
        //title loading...loading...5 sec(this website is like this) and then title says "Dynamic Title"
        //so we need to wait for title to become "Dynamic title" 10 sec max
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        wait.until(ExpectedConditions.visibilityOf(x.spongeBobImage));

        //Assert
        Assert.assertTrue(x.doneMessage.isDisplayed());
        Assert.assertTrue(x.spongeBobImage.isDisplayed());
    }


    /**
     * //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
     *         //2. Click to start
     *         //3. Wait until loading bar disappears
     *         //4. Assert username inputbox is displayed
     *         //5. Enter username: tomsmith
     *         //6. Enter password: incorrectpassword
     *         //7. Click to Submit button
     *         //8. Assert “Your password is invalid!” text is displayed.
     */
    @Test
    public void dynamic_loading_1_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        dynamicLoad1Page.startButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");
        dynamicLoad1Page.submitButton.click();
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}




















