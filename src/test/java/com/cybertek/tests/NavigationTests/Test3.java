package com.cybertek.tests.NavigationTests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test3 {

    WebDriver driver;


    @Test
    public void test1() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement acceptCokie=driver.findElement(By.cssSelector(".wt-btn.wt-btn--filled.wt-mb-xs-0"));
        Thread.sleep(3000);

        acceptCokie.click();

        Thread.sleep(3000);

        getMenu("Art & Collectible").click();
        Thread.sleep(1000);

        getMenu("Toys & Entertainment").click();
        Thread.sleep(1000);

        getMenu("Wedding & Party").click();
        Thread.sleep(1000);

        getMenu("Home & Living").click();
        Thread.sleep(1000);

        getMenu("Wedding & Party").click();
        Thread.sleep(1000);

        getMenu2("Art & Collectible");
        Thread.sleep(1000);

        getMenu2("Toys & Entertainment");
        Thread.sleep(1000);

        getMenu2("Wedding & Party");
        Thread.sleep(1000);

        getMenu2("Home & Living");
        Thread.sleep(1000);

        getMenu2("Wedding & Party");
        Thread.sleep(1000);






        driver.quit();



    }

    public WebElement getMenu(String menu){

        WebElement menuPage=driver.findElement(By.xpath("//span[contains(text(),'"+menu+"')]"));


        return menuPage;
    }


    public void  getMenu2(String menu) throws InterruptedException {

        WebElement menuPage=driver.findElement(By.xpath("//span[contains(text(),'"+menu+"')]"));


        menuPage.click();
        Thread.sleep(1000);

    }

}
