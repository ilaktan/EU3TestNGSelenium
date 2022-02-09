package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public  void SwitchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("Title before new window:" + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();


        //System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle=driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){

                driver.switchTo().window(handle);



            }

        }
        System.out.println("Title After new window:" + driver.getTitle());



    }
    @Test
    public  void moreThan2Window(){

        driver.get("http://practice.cybertekschool.com/windows");

        //get title

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(" Before  Switch:" + driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);

            if(driver.getTitle().equals("New Window")){

                break;

            }
            
        }
        System.out.println("After switch = " + driver.getTitle());


    }
}
