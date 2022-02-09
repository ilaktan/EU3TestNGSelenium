package com.cybertek.tests.HomeWork;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vytrack_HW_1 extends TestBase {

    @Test
    public void test1(){
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager

        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //4. Verify that page subtitle "Options" is displaye
        WebElement options= driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']"));
        Assert.assertEquals(options.getText(),"Options");


    }
    @Test
    public void test2() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //4. Verify that page number is equals to "1"

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        WebElement option= driver.findElement(By.xpath("//input[@*='1']"));
        Assert.assertEquals(option.getAttribute("value"),"1");



    }
    @Test
    public void test3() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //3. Navigate to “Activities -> Calendar Events”
        //4. Verify that view per page number is equals to
        //"25"
       WebElement twentyfive=driver.findElement(By.xpath("(//div[@class='btn-group'])[2]"));

       Assert.assertEquals(twentyfive.getText(),"25");




//        Thread.sleep(3000);
//       twentyfive.click();






//
//        System.out.println(pageOptions.get(1).getText());


    }
    @Test
    public void test4() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //4. Verify that number of calendar events (rows in
        //the table) is equals to number of records
        Thread.sleep(2000);
        String totalOfRecord=driver.findElement(By.xpath("//*[text()='Total of 4046 records']")).getText();


        //System.out.println(driver.findElement(By.xpath("(//label[@class=\"dib\"])[3]")).getText());

        Assert.assertEquals(totalOfRecord,"Total Of 4046 Records");

        String xpath="//*[text()='Total of "+4046+" records']";
        WebElement email=driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }
    @Test
    public void test5() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //4. Click on the top checkbox to select all
        //5. Verify that all calendar events were selected
        WebElement checkBox= driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));

        checkBox.click();
        Thread.sleep(2000);
        Assert.assertTrue(checkBox.isSelected());

    }
    @Test
    public void test6() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");



        WebElement title=driver.findElement(By.xpath("//*[text()='Title']"));
        Thread.sleep(2000);
        title.click();

        Thread.sleep(2000);
        title.click();
        Thread.sleep(2000);

        WebElement data=driver.findElement(By.xpath("(//ul[@class='icons-holder']//li//a)[2]"));
        data.click();
        Thread.sleep(2000);

        WebElement testerMeeting=driver.findElement(By.xpath("(//td[text()='Testers meeting'])[3]"));
        testerMeeting.click();
        Thread.sleep(5000);

       Assert.assertEquals(driver.findElement(By.xpath("//span[text()='This is a a weekly testers meeting']")).getText(),"This is a a weekly testers meeting");


//        Select repeadDropdown=new Select(title);
//
//        List<WebElement> expectedOptions =repeadDropdown.getOptions();
//   ((//tbody[@class='grid-body']/tr)[9]//td)[4]
//        expectedOptions.get(2).click();





//       // WebElement title=driver.findElement(By.xpath("//*[text()='Title']"));
//        WebElement title=driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
//        Thread.sleep(3000);
//        title.click();
//        Thread.sleep(3000);
//        title.click();
//        Thread.sleep(3000);

//        WebElement texster=driver.findElement(By.xpath("(//tbody/tr)[9]"));
//        texster.click();(//span[@class='caret'])[10]



    }

}
