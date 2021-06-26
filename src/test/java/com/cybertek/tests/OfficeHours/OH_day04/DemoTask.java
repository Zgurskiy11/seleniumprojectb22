package com.cybertek.tests.OfficeHours.OH_day04;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.OscarUtil;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTask {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void settingName()  {
        OscarUtil.settingCredentials(driver, "Anton", "12345");
        BrowserUtils.sleep(2);
    }

    @Test
    public void test() throws InterruptedException {
        //using configuration properties
        driver.get(ConfigurationReader.getProperty("oscarWebsite"));

        String title = driver.getTitle();
        String expTitle = "Login example page to test the PHP MySQL online system";
        Assert.assertEquals(expTitle, title);
        String header = driver.findElement(By.xpath("(//p[@align = 'center'])[4]")).getText();
        String expHeader = "4. Login";
        Assert.assertEquals(expHeader, header);
        String status = driver.findElement(By.xpath("(//blockquote)[2]")).getText();
        String expStatus = "**No login attempted**";
        Assert.assertEquals(status, expStatus);
        String info = driver.findElement(By.xpath("(//p[@align='center'])[6]")).getText();
        String expInfo = "Enter your login details you added on the previous page and test the login.\n" +
                "The success or failure will be shown above.";
        Assert.assertEquals(info, expInfo);
        //locating username field, and see if its displayed
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        Assert.assertTrue(username.isDisplayed());
        //same with password field
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Assert.assertTrue(password.isDisplayed());
        //test login button, click and see if pop ups
        WebElement button = driver.findElement(By.xpath("//input[@type='button']"));
        button.click();
        BrowserUtils.sleep(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //creating name and password
        String actualName = ConfigurationReader.getProperty("oscarName");;
        String actualPassword = ConfigurationReader.getProperty("oscarPassword");


        username.sendKeys(actualName);
        password.sendKeys(actualPassword);
        button.click();
        //verifying login successful is displayed
        String actualLogin = driver.findElement(By.xpath("//big//b")).getText();
        String expLogin = "**Successful Login**";
        Assert.assertEquals(actualLogin, expLogin);
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    //        //trying wrong username
    @Test
    public void wrongLogin() {
        driver.get(" http://thedemosite.co.uk/login.php");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Cybertek");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String message = driver.findElement(By.xpath("//big//b")).getText();
        String expectedMessage = "**Successful Login**";
        Assert.assertNotEquals(expectedMessage, message);
    }
}



















