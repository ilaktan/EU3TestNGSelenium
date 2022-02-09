package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class   CheckboxHW {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("Chrome");
        //driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();


    }
    @Test
    public  void test1() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");


        WebElement checkAll=driver.findElement(By.xpath("//input[@type='button']"));
        String expected="Check All";
        Assert.assertEquals(checkAll.getAttribute("value"),"Check All");

        List<WebElement> options = driver.findElements(By.className("cb1-element"));

        for (WebElement option : options) {

        }
        options.get(0).click();
        options.get(1).click();
        options.get(2).click();
        options.get(3).click();
        Assert.assertTrue(options.get(0).isSelected(),"verify that  is  selected");
        Assert.assertTrue(options.get(1).isSelected(),"verify that  is  selected");
        Assert.assertTrue(options.get(2).isSelected(),"verify that  is  selected");
        Assert.assertTrue(options.get(3).isSelected(),"verify that  is  selected");
        Assert.assertEquals(checkAll.getAttribute("value"),"Uncheck All");




    }
    @Test
    public  void test2(){
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement sucsess=driver.findElement(By.xpath("//*[text()='Success - Check box is checked']"));
        String expected="Success - Check box is checked";

        Assert.assertFalse(sucsess.isDisplayed(),expected);


        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element : elements) {

        }
        elements.get(0).click();
        Assert.assertTrue(sucsess.isDisplayed(),"Check box is checked");


    }
}
