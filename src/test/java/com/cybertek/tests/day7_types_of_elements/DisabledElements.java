package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement greenRadioBtn=driver.findElement(By.xpath("//*[@id=\"green\"]"));

        //how to check any web element is anabled or not

        System.out.println("greenRadioBtn.isSelected() = " + greenRadioBtn.isSelected());

        Assert.assertFalse(greenRadioBtn.isEnabled(),"verify green button Not enabled (disabled)");

        greenRadioBtn.click();

    }

    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox=driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));

        inputbox.sendKeys("some message");


    }
}




