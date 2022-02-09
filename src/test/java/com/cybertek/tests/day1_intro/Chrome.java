package com.cybertek.tests.day1_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/ilhanaltan/Documents/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("www.google.com");
        System.out.println(driver.getTitle());
    }
}
