package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("Chrome");
        //driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

    }
    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();


    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1=driver.findElement(By.tagName("img"));
        //Actions -->class that contains all the user interactions
        //how to create actions object-->passing driver as a constructor

        Actions actions=new Actions(driver);




        //perform() perform the action complete the action
        //moveToElement -->move you mouse to webelement(hover over)


        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink=driver.findElement(By.xpath("//*[.='View profile']"));
        Assert.assertTrue(viewLink.isDisplayed(),"verify view link displayed");
        //actions.moveToElement(viewLink).perform();
    }
    @Test
    public  void dragANdDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        driver.manage().window().maximize();
        Actions actions=new Actions(driver);


        List<WebElement> acceptAndClose = driver.findElements(By.id("onetrust-accept-btn-handler"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept and Close']"));

        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }


        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        //driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();

    }


    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        driver.manage().window().maximize();
        Actions actions=new Actions(driver);


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();



        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


    }

}
