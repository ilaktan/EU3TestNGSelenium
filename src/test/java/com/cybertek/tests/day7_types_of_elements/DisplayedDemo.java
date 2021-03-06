package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput=driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //verify username inputbox is not dispalyed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"verify usernameinput not display");
        //click start button
        WebElement startButton=driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();
        //verify username displayed on the screen


        Thread.sleep(6000);
        Assert.assertTrue(usernameInput.isDisplayed());

        driver.quit();


    }
}
