package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.TelerikPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
// we already did this task. Just trying to use POM design
/**
 *         //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
 *        //2. Drag and drop the small circle to bigger circle.
 *       //3. Assert:
 *      //             -Text in big circle changed to: “You did great!”
 */

public class ActionsPractices {

    @Test
    public void drag_and_drop_test(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");//sometimes when u go there, cookie pop up appear, just click accept or scroll down and ignore pop up.

        //created class TelerikPage in pages package(object page). Gonna create object of it:
        TelerikPage x = new TelerikPage();

        //creating Actions object, and passing our driver:
        Actions actions = new Actions(Driver.getDriver());

        //accepting the cookies
        BrowserUtils.sleep(2);
        x.acceptCookieButton.click();  // x - is our TelerikPage's object. Can use @FindBy buttons now.

BrowserUtils.sleep(3);//
        //drag and drop:        source.       target.     dont forget .perform!!!!!!!
        actions.dragAndDrop(x.smallCircle,x.bigCircle).perform();

        // Second way of doing the same thing
      //  actions.moveToElement(x.smallCircle).clickAndHold(x.smallCircle).moveToElement(x.bigCircle).release().perform();

        //Assertion. At the end.
        String exp = "You did great!";
        String act = x.bigCircle.getText();
        Assert.assertEquals(act,exp);





    }


}


























