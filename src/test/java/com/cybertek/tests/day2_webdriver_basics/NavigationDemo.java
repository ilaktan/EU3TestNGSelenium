package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        //System.setProperty("webdriver.chrome.driver","/Users/ilhanaltan/Downloads/chromedriver");
//
        WebDriver driver=new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//
//        WebDriver driver=new FirefoxDriver();

        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();

        driver.navigate().refresh();

    }
}
