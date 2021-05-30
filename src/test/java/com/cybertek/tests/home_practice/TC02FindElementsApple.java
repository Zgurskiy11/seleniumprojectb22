package com.cybertek.tests.home_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
//TC #02: FINDELEMENTS_APPLE
// 1.Open Chrome browser
// 2.Go to https://www.apple.com
// 3.Click to iPhone
// 4.Print out the texts of all links
// 5.Print out how many link is missing text
// 6.Print out how many link has text
// 7.Print out how many total link

public class TC02FindElementsApple {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().window().maximize();
        // 3.Click to iPhone
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("allLinks.size() = " + allLinks.size());
// 4.Print out the texts of all links
        int totalLinks = 0;
        for (WebElement each : allLinks) {
            totalLinks++;
            System.out.println(each.getText());
        }
// 5.Print out how many link is missing text  ++  6.Print out how many link has text
        int linksWithMissingText = 0;
        int linksWithText = 0;
        for (WebElement each : allLinks) {
            if (each.getText().isEmpty()){
                linksWithMissingText++;
            }else{
                linksWithText++;
            }
        }
        System.out.println("linksWithText = " + linksWithText);
        System.out.println("linksWithMissingText = " + linksWithMissingText);
        System.out.println("totalLinks = " + totalLinks);// or .size()






    }
}
