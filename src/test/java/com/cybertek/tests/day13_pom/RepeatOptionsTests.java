package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {
     /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */
    //TASK UNTIL 12:45
    @Test
    public void test1() throws InterruptedException {
        //* Open Chrome browser
        //* Login as a Driver
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();

        //Go to Activities->Calendar Events
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //  Click on create calendar events
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        //Thread.sleep(2000);
        calendarEventsPage.createCalendarEvent.click();

        //    Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Thread.sleep(2000);
        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

        //    verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());





    }
       /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

    @Test
    public void test2() throws InterruptedException {
        //* Open Chrome browser
        //* Login as a Driver
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();

        //Go to Activities->Calendar Events
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //  Click on create calendar events
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        Thread.sleep(2000);
        calendarEventsPage.createCalendarEvent.click();

        //    Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        //Select repeadDropdown=new Select(createCalendarEventsPage.repeatOptions);
        Select repeadDropdown=createCalendarEventsPage.repeatOptionsList();
        List<String> expectedOptions = Arrays.asList("Daily","Weekly","Monthly","Yearly");

       List<WebElement> actualOptions = repeadDropdown.getOptions();
//        List<String> actualList = new ArrayList<>();
//        for (WebElement actualOption : actualOptions) {
//            actualList.add(actualOption.getText());
//
//        }

        List<String> actualList =BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedOptions);



//        Assert.assertEquals(actualOptions.get(0).getText(),expectedOptions.get(0));
//        Assert.assertEquals(actualOptions.get(1).getText(),expectedOptions.get(1));
//        Assert.assertEquals(actualOptions.get(2).getText(),expectedOptions.get(2));
//        Assert.assertEquals(actualOptions.get(3).getText(),expectedOptions.get(3));






    }
}
