package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
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
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");


        //click the destroy the world button
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        //click no button
        driver.findElement(By.xpath("//button[.='No']"));
    }
    @Test
    public  void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click "Click JS Alert"
        driver.findElement(By.xpath("//button[1]")).click();

        //Click Ok button
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //Click"Click for JS Confirm"
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);

        //Click no button
        alert.dismiss();

        //Click"Click for JS Prompt"
        driver.findElement(By.xpath("//button[3]")).click();

        //sending keys
        alert.sendKeys("MakeSmith");
        Thread.sleep(3000);
        alert.accept();


    }

}

