package com.cybertek.tests;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class GroupProject {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");

    }

    @Test
    public void testing() throws InterruptedException {
        //Logging it
        WebElement nameLogin = driver.findElement(By.xpath("//input[@name='_username']"));
        nameLogin.sendKeys("user4");
        WebElement passwordLogin = driver.findElement(By.cssSelector("input[type='password']"));
        passwordLogin.sendKeys("UserUser123"+ Keys.ENTER);
       // Thread.sleep(3000);
//        try {
//            driver.findElement(By.xpath("//div[@class = 'ui-dialog-titlebar-buttonpane']/button")).click();
//        }catch (NoSuchElementException e ){
//
//        }
//clicking on fleet
        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]")).click();
       // Thread.sleep(3000);

//clicking on vehicles
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]")).click();

//clicking on fifth vehicle(can be any vehicle by requirements):
        driver.findElement(By.xpath("//tr[@class='grid-row row-click-action'][5]")).click();//tbody//tr[2]
       // Thread.sleep(4000);

//clicking on "ADD EVENT" button, and window pops up
       WebElement addEventButton= driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
      //  Thread.sleep(3000);
        addEventButton.click();

//now  add TITLE and click SAVE button.
        String eventTitle="Cybertek2";
          driver.findElement(By.xpath("(//input[contains(@id, 'oro_calendar_event')])[1]")).sendKeys(eventTitle+Keys.ENTER);
//finding and opening Activity
         WebElement x= driver.findElement(By.xpath("//a[@href='#scroll-2-1603']"));
         x.click();

         //checking if our event is there

        String actualResult =driver.findElement(By.xpath("(//strong[.='Cybertek2'])[1]")).getText();
        String expectedResult="Cybertek2";

        Assert.assertEquals(actualResult,expectedResult);

    }

}





















