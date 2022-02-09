package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IDLocarorsTest {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //Click don't click button
        WebElement ClickButton= driver.findElement(By.id("disappearing_button"));

        ClickButton.click();
    }
}
