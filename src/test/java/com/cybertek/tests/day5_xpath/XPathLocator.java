package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //Click don't click button
        WebElement button1= driver.findElement(By.xpath("//button[@onclick='button1()']"));

       button1.click();
        Thread.sleep(2000);
       driver.quit();
    }
}
