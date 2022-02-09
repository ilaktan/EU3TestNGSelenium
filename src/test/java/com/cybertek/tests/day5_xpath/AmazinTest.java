package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazinTest {
    public static void main(String[] args) {

        //Task
        // go to amazon.com
        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.amazon.com/");

        //search for selenium
        WebElement seachBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        seachBox.sendKeys("Selenium");
        WebElement seachButton= driver.findElement(By.xpath("//input[@value='Go']"));

        seachButton.click();
        //WebElement result= driver.findElement(By.xpath("//span[@dir='auto']"));
        WebElement result= driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        System.out.println(result.getText());
        String expectedResult="1-48 of 132 results for";

        if(expectedResult.equals(result.getText())){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("result.getText() = " + result.getText());
        }
        driver.quit();
    }
}
