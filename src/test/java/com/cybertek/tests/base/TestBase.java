package com.cybertek.tests.base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {  //cant create object from this class. That's what we need

    public WebDriver driver;//making public, so we can use it in child class

    @BeforeMethod
    public void setupMethod(){
        String browser = ConfigurationReader.getProperty("browser");//passing KEY of the value we need. Its in configuration file we created
        driver = WebDriverFactory.getDriver(browser);//passing browser var we just created here
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
