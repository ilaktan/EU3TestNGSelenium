package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class HoverTest {

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
    //hover over each image in the webpage
    //verify each name user text is displayed

    @Test
    public  void  oneImage() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));

        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement text1= driver.findElement(By.xpath("//h5[text()='name: user1']"));

        //Assert.assertEquals(text1,"name: user1\n");
        Thread.sleep(2000);
        Assert.assertTrue(text1.isDisplayed());



    }
    @Test
    public  void Test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");


        for (int i = 1; i <=3; i++) {
            WebElement img=driver.findElement(By.xpath("(//img)["+i+"]"));

            Actions actions=new Actions(driver);

            Thread.sleep(2000);
            actions.moveToElement(img).perform();

            WebElement text1= driver.findElement(By.xpath("//h5[text()='name: user"+i+"']"));

            Assert.assertTrue(text1.isDisplayed());
        }






    }

}
