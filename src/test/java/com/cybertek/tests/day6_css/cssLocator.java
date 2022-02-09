package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //Click don't click button
        WebElement dontClick=driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(dontClick.getText());
        driver.quit();

    }
}
