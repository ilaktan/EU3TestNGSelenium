package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver= new FirefoxDriver();
        driver.get("http://practice.cybertekschool.com");


        //option hold hit enter
        String title = driver.getTitle();
        System.out.println("title = " + title);

        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
        

    }
}
