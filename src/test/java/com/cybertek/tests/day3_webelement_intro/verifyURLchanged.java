package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) {
//        Verify URL changed
//        open browser
//        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
//        enter any email
//        click on Retrieve password
//        verify that url changed
//        to http://practice.cybertekschool.com/email_sent
//        close browser
        //        open browser
        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        //        go to http://practice.cybertekschool.com/forgot_password Links to an external site.

        driver.get("http://practice.cybertekschool.com/forgot_password");


        //        enter any email

        WebElement emailInputBox=driver.findElement(By.name("email"));
        String expectedUrl="http://practice.cybertekschool.com/email_sents";

        emailInputBox.sendKeys("mike@cybertek.com");
        //        click on Retrieve password
    WebElement retrivePasswordButton= driver.findElement(By.id("form_submit"));

    retrivePasswordButton.click();
        String actualUrl=driver.getCurrentUrl();

        //        verify that url changed
//        to http://practice.cybertekschool.com/email_sent

        if(actualUrl.equals("http://practice.cybertekschool.com/email_sents")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }
        //close browser
        driver.quit();
    }
}
