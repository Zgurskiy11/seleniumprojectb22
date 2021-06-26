package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelerikPage {

    //create public constructor(rule)

    public TelerikPage(){
        PageFactory.initElements(Driver.getDriver(),this);//this.object. I wanna introduce this object of the class to our driver, so we can use selenium methids
    }

    @FindBy(id="draggable")// inspected Telerik page from drug and drop task. Locate Circle by id
    public WebElement smallCircle;

    @FindBy(id="droptarget")
    public WebElement bigCircle;

    @FindBy(id="onetrust-accept-btn-handler")//locating this, because it pops up when we go to website.
    public WebElement acceptCookieButton;

}
