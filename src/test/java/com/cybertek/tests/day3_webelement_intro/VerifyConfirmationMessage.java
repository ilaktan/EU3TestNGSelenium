package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) {
//        Verify confirmation message
//        open browser
//        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
//        enter any email
//        verify that email is displayed in the input box
//        click on Retrieve password
//        verify that confirmation message says 'Your e-mail's been sent!'
        //        open browser
        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        //        go to http://practice.cybertekschool.com/forgot_password Links to an external site.

        driver.get("http://practice.cybertekschool.com/forgot_password");
        //        enter any email

        WebElement emailBox=driver.findElement(By.name("email"));

        String expectedEmail="mike@smith.com";

        emailBox.sendKeys(expectedEmail);
//        verify that confirmation message says 'Your e-mail's been sent!'

        String actualEmail=emailBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        //        verify that email is displayed in the input box

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //        click on Retrieve password

        WebElement retrivePasswordButton=driver.findElement(By.id("form_submit"));

        retrivePasswordButton.click();
        //        verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualConfirmationMessage=driver.findElement(By.name("confirmation_message"));
        System.out.println(actualConfirmationMessage.getText());

        String actualMessage=actualConfirmationMessage.getText();

        String expectedMessage="Your e-mail's been sent!";
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Pass");

        }else{
            System.out.println("fail");
        }


        driver.quit();
    }
}
