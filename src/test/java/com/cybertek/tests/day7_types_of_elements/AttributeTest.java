package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueRadioBtn=driver.findElement(By.xpath("//*[@id=\"blue\"]"));

        blueRadioBtn.getAttribute("value");
        //get the value of type attribute
        System.out.println("blueRadioBtn.getAttribute(\"type\") = " + blueRadioBtn.getAttribute("type"));

        //get the value of name attribute
        System.out.println("blueRadioBtn.getAttribute(\"name\") = " + blueRadioBtn.getAttribute("name"));
        //since checked attrubitte does not keep any value return true or false
        System.out.println("blueRadioBtn.getAttribute(\"checked\") = " + blueRadioBtn.getAttribute("checked"));
        //when we use non exist attrubitte it will return null to us
        System.out.println("blueRadioBtn.getAttribute(\"href\") = " + blueRadioBtn.getAttribute("href"));
        System.out.println("blueRadioBtn.getAttribute(\"outerHTML\") = " + blueRadioBtn.getAttribute("outerHTML"));
        System.out.println("----------------------");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2= driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML=button2.getAttribute("outerHTML");

        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("Inner HTML"+button2.getAttribute("innerHTML"));
        driver.quit();
    }
}
