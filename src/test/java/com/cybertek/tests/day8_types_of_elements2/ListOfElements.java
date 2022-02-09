package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
         driver= WebDriverFactory.getDriver("Chrome");

    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("Button"));

        System.out.println("buttons.size() = " + buttons.size());


        Assert.assertEquals(buttons.size(),6,"verify button size");

        //iter+ enter to get each loop with shortcut
        for (WebElement button : buttons) {
            System.out.println(button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed());

            Assert.assertTrue(button.isDisplayed(),"verify button is displayed");
        }

        //click second button
        buttons.get(1).click();
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //passing locator which does not exist
        //Alt+enter or option+enter give you list element shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("Buttonsdsa"));
        System.out.println("buttons.size() = " + buttons.size());

    }
}
