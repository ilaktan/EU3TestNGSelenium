package com.cybertek.tests.Group14;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class testdropdown {

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
    public void test() throws InterruptedException {

        driver.get("https://www.seleniumeasy.com/test/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[.='No, thanks!']")).click();
        WebElement inputformstext = driver.findElement(By.xpath("//a[.='Input Forms']"));
        inputformstext.click();
        Thread.sleep(2000);
        WebElement dropdownlist = driver.findElement(By.xpath("//body/div[@id='easycont']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[4]/a[1]"));
        dropdownlist.click();
        Thread.sleep(2000);

        WebElement selectdemo = driver.findElement(By.xpath("//*[@id=\"select-demo\"]"));
        selectdemo.click();
        Thread.sleep(4000);
        Select dayDropdown = new Select(selectdemo);
       // List<WebElement> allSelectedOptions = dayDropdown.getAllSelectedOptions();
       // System.out.println("allSelectedOptions.size() = " + allSelectedOptions.size());


        List<WebElement> days = selectdemo.findElements(By.xpath("//*[@id=\"select-demo\"]"));
        System.out.println(days.size());
        for (WebElement day : days) {
            System.out.println(day.getText());
        }
        List<WebElement> options = dayDropdown.getOptions();
        System.out.println("options.size() = " + days.size());
        dayDropdown.selectByValue("Tuesday");
        Thread.sleep(2000);
        dayDropdown.selectByValue("Friday");
        Thread.sleep(2000);


    }

    }

