package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("Chrome");

    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Ok']")).click();
        Thread.sleep(2000);


        //How to switch frames
        //1.switch using by name or ID attribute of iframe

        WebElement myframe=driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(myframe);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //goes back to first frame(main html)
        //goes back to firstframe,useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.switching with INDEX
        driver.switchTo().frame(0);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with index");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3.using webelement
        WebElement iframeElement=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with webelement");


    }
    @Test
    public  void test2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");
        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under left middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());


        //goes back to top frame
        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        //html main
        //frame_top(parent frame)
        // index 0 left
        // index 1 middle
        // index 2 right
        //frame bottom



        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());






    }
}
