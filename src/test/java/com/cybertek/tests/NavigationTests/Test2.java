package com.cybertek.tests.NavigationTests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void test1() throws InterruptedException {
        // 1.Open   Chrome browser
//2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
// 3.Verify    "Success   –  Check  box    is checked"   message    is NOT    displayed.
// 4.Click to checkbox   under  "Single    Checkbox   Demo"  section
// 5.Verify    "Success   –  Check  box    is checked"   message    is displayed

        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement txtBox=driver.findElement(By.id("txtAge"));
        WebElement checkbox=driver.findElement(By.id("isAgeSelected"));
        checkbox.click();
        Thread.sleep(3000);
    }
}
