package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput= driver.findElement(By.name("full_name"));

        fullNameInput.sendKeys("Mike Smith");

        //task
        //put some email and click sign up button

        WebElement emailInput=driver.findElement(By.name("email"));

        emailInput.sendKeys("asas@sasa.com");

        WebElement signUpInput=driver.findElement(By.name("wooden_spoon"));
        signUpInput.click();
    }

}
