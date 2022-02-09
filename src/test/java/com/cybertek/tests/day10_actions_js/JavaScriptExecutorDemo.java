package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
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
    public void clickWithJS()  {
        driver.get("http://practice.cybertekschool.com");
        WebElement dropdownLink=driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",dropdownLink);

    }
    @Test
    public void typeWithJS()  {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox=driver.findElement(By.cssSelector("#input-example>input"));

        //driver.executeScript("arguments[0].setAttribute('value', '" + longstring +"')", inputField);

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        String text="Hello Disabled Input";

        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputbox);

    }
    @Test
    public  void  scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");

        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");

        }





    }
    @Test

    public void  scrollToElement() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        WebElement eng=driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
        Thread.sleep(2000);
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //     "arguments[0].scrollIntoView(true);", element
        jse.executeScript("arguments[0].scrollIntoView(true);", eng);
    }
}
