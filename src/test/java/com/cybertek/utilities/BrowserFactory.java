package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public static String  getDriver(String str){

        str="chrome";
        WebDriver driver=WebDriverFactory.getDriver(str);



        return "null";
    }
}
