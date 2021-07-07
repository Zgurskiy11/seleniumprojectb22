package com.cybertek.pages;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {  //use it in day 14

    public DynamicLoad1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //locate START button
    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    //locate loading bar, while its loading inspect it
    @FindBy(id = "loading")
    public WebElement loadingBar;

    //locate input boxes for username and password
    @FindBy(id = "username")
    public WebElement inputUsername;

    @FindBy(id = "pwd")
    public WebElement inputPassword;

    //locate submit button:
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    //entering username and 'incorrectpassword'. Verify displayed message
    @FindBy(id = "flash")
    public WebElement errorMessage;

    /**
     *     that's all elements we need for our test
     */






}
