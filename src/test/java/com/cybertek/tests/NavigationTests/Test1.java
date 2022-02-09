package com.cybertek.tests.NavigationTests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        //1.Open browser
        //2.Go to website https://google.com
        // 3.Savethe titlein a string variable
        // 4.Go to https://etsy.com
        // 5.Savethe title in a string variable
        // 6.Navigate back to previouspage
        // 7.Verify that title is same is in step 3
        // 8.Navigate forward to previous page
        // 9.Verify that title is same is in step 5

        //1.Open browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2.Go to website https://google.com
        driver.get("https://google.com");

        // 3.Savethe titlein a string variable
        String expectedGoogleUrl=driver.getCurrentUrl();

        // 4.Go to https://etsy.com
        Thread.sleep(3000);
        driver.navigate().to("https://etsy.com");

        // 5.Savethe title in a string variable
        String expectedEtsyUrl=driver.getCurrentUrl();


        // 6.Navigate back to previouspage
        Thread.sleep(3000);
        driver.navigate().back();

        // 7.Verify that title is same is in step 3
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.equals(expectedGoogleUrl));

        // 8.Navigate forward to previous page
        Thread.sleep(3000);

        driver.navigate().forward();
        String actualStep8Url=driver.getCurrentUrl();

        // 9.Verify that title is same is in step 5
        Assert.assertTrue(actualStep8Url.equals(expectedEtsyUrl));
    }
}
