package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1() throws InterruptedException {
          //* Open Chrome browser
                //* Login as a Driver
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();

        String expectedSubtitle="Quick Launchpad";

        DashboardPage dashboardPage=new DashboardPage();
        String actualSubtitle=dashboardPage.getPageSubTitle();
        Thread.sleep(2000);

        //* Verify that page subtitle is Quick Launchpad
        Assert.assertEquals(actualSubtitle,expectedSubtitle);

        //* Go to Activities -> Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //     * verify that page subtitle is Calendar Events

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");
    }
}
