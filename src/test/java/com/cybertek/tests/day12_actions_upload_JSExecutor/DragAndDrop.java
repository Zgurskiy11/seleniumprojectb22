package com.cybertek.tests.day12_actions_upload_JSExecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test
    public void DragAndDropTest() {
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //accept cookies
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        BrowserUtils.sleep(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 1600)");

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement biggerCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //WebElement biggerCircle = Driver.getDriver().findElement(By.xpath("//div[.='Drag the small circle here.']"));


        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, biggerCircle).perform(); //we are moving source to target

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        WebElement textInBigCircle = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']"));
        String expectedTextInBigCircle = "You did great!";
        String actualTextInBigCircle = textInBigCircle.getText();

        Assert.assertEquals(expectedTextInBigCircle, actualTextInBigCircle);
        Driver.closeDriver();
    }

}
