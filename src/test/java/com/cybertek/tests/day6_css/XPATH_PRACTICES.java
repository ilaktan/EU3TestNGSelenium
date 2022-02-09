package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPATH_PRACTICES {
    public static void main(String[] args) {
//        XPATH PRACTICES
//
//        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
//
//        1. Open Chrome browser
//
//        2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
//
//        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
//
//        a. “Home” link
//
//        b. “Forgot password” header
//
//        c. “E-mail” text
//
//        d. E-mail input box
//
//        e. “Retrieve password” button
//
//
//
//        4.Print text of a,b,c,e and put some email to d
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeText=driver.findElement(By.xpath("//a[@class='nav-link']"));

        WebElement forgotPassword=driver.findElement(By.xpath("//h2[contains(text(),'Forgot')]"));
        WebElement eMail=driver.findElement(By.xpath("//label[@for='email']"));
        WebElement eMailInputBox=driver.findElement(By.xpath("//input[@type='text']"));
        eMailInputBox.sendKeys("asasa@sasa.com");
        WebElement retrievePassword=driver.findElement(By.xpath("//button[@id='form_submit']"));

        String actualEmail=eMailInputBox.getAttribute("value");

        System.out.println(homeText.getText());
        System.out.println(forgotPassword.getText());
        System.out.println(eMail.getText());
        System.out.println(retrievePassword.getText());

        System.out.println(actualEmail);

        driver.quit();

    }
}
